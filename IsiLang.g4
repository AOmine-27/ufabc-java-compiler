grammar IsiLang;

@header{
	import br.com.ufabc.mycompiler.datastructures.Symbol;
	import br.com.ufabc.mycompiler.datastructures.Variable;
	import br.com.ufabc.mycompiler.datastructures.SymbolTable;
	import br.com.ufabc.mycompiler.exceptions.SemanticException;
	import br.com.ufabc.mycompiler.ast.Program;
	import br.com.ufabc.mycompiler.ast.AbstractCommand;
	import br.com.ufabc.mycompiler.ast.CommandLeitura;
	import br.com.ufabc.mycompiler.ast.CommandEscrita;
	import br.com.ufabc.mycompiler.ast.CommandAtribuicao;
	import br.com.ufabc.mycompiler.ast.CommandDecisao;
	import br.com.ufabc.mycompiler.ast.CommandWhile;
	import br.com.ufabc.mycompiler.ast.CommandFor;
	import br.com.ufabc.mycompiler.ast.CommandAtribuicaoFor;
	import java.util.ArrayList;
	import java.util.Stack;
}

@members{
	private int _tipo;
	private String _varName;
	private String _varValue;
	private SymbolTable symbolTable = new SymbolTable();
	private Symbol symbol;
	private Program program = new Program();
	private ArrayList<AbstractCommand> curThread;
	private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
	
	private int leftDT;
	private int rightDT;

	private CommandAtribuicaoFor _statement1;
	private String _statement2;
	private CommandAtribuicaoFor _statement3;
	
	private String _readID;
	private String _writeID;
	private boolean _writeLn;
	private String _exprID;
	private String _exprContent;
	private String _exprDecision;
	private ArrayList<AbstractCommand> listaTrue;
	private ArrayList<AbstractCommand> listaFalse;
	
	public void verificaIDDeclarado(String id) {
		if (!symbolTable.exists(id)) {
			throw new SemanticException("Symbol " + id + " not declared");
		}
	}

	public void setVariableUsage(String id) {
		Symbol variable = symbolTable.get(id);
		variable.setUsed(true);
	}
	
	public void checkVariableHasValue(String id) {
		Variable variable = (Variable) symbolTable.get(id);
		if (variable.getValue() == null) {
			throw new SemanticException("Variable " + id + " does not have value.");
		}
	}
	
	public void generateCode() {
		program.generateTarget();
	}

	public void checkUnusedVariables() {
		ArrayList<Symbol> variableList = symbolTable.getAll();
		for (Symbol symbol : variableList) {
			if (!symbol.isUsed()) {
				System.out.println("Warn: declared variable " + symbol.getName() + " is not being used.");
			}
		}
	}
}

prog		:	'programa' 
				declara 
				(bloco)? 
				'fimprog' 
				{ 
					program.setVarTable(symbolTable);
					program.setComandos(stack.pop());
					checkUnusedVariables();
				}
				PT
			;

declara		:	(declaravar)+   
			;

declaravar	:	'declare' tipo ID 
				{
					_varName = _input.LT(-1).getText();
					_varValue = null;
					symbol = new Variable(_varName, _tipo, _varValue);
					if (!symbolTable.exists(_varName)) {
						symbolTable.add(symbol);
					} else {
						throw new SemanticException("Symbol " + _varName + " already exists");
					}
					
				}
				(VIR 
				ID 
				{
					_varName = _input.LT(-1).getText();
					_varValue = null;
					symbol = new Variable(_varName, _tipo, _varValue);
					if (!symbolTable.exists(_varName)) {
						symbolTable.add(symbol);
					} else {
						throw new SemanticException("Symbol " + _varName + " already exists");
					}
				})* 
				PT 
			;

tipo		:	'numero' 
				{
					_tipo = Variable.NUMBER;
				}
				| 'texto'  
				{
					_tipo = Variable.TEXT;
				}
			;

bloco		:	{
					curThread = new ArrayList<AbstractCommand>();
			 		stack.push(curThread);
				}
				(cmd PT)+
			;

cmd			: 	cmdleitura
		  		| cmdescrita
		  		| cmdexpr
		  		| cmdif
				| cmdwhile
				| cmddowhile
				| cmdfor
			;

cmdleitura	: 	'leia' 
				AP  
				ID 
				{	
					verificaIDDeclarado(_input.LT(-1).getText());
					_readID = _input.LT(-1).getText();
				}
				FP 
				{
					Variable var = (Variable)symbolTable.get(_readID);
					var.setValue("");
					CommandLeitura cmd = new CommandLeitura(_readID, var);
					stack.peek().add(cmd);
				}
		  	;

cmdescrita	: 	('escreva' 
				{
					_writeLn = false;
				}
				| 'escrevaLn' 
				{	
					_writeLn = true;
				}) 
				AP
				(ID 
				{
					verificaIDDeclarado(_input.LT(-1).getText());
					_writeID = _input.LT(-1).getText();
					checkVariableHasValue(_writeID);
					setVariableUsage(_writeID);
				}
				| TEXTO 
				{
					_writeID = _input.LT(-1).getText();
				}
				| 
				{
					_exprContent = "";
				} 
				(expr | 
				exprText) 
				{
					_writeID = _exprContent;
				}
				)FP 	  
				{
					CommandEscrita cmd = new CommandEscrita(_writeID, _writeLn);
					stack.peek().add(cmd);
				}
			;

cmdexpr     :	ID 
				{	verificaIDDeclarado(_input.LT(-1).getText());
                  	_exprID = _input.LT(-1).getText();
					Variable leftVar = (Variable) symbolTable.get(_input.LT(-1).getText());
					leftDT = leftVar.getType();
					rightDT = -1;
				} 
			  	ATTR 
				{
					_exprContent = "";
				} 
			  	(expr | 
				exprText)
			   	{	
					CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
					Variable var = (Variable)symbolTable.get(_exprID);
					var.setValue(_exprContent);
			  	  	stack.peek().add(cmd);
				}
		  	;

cmdif		: 	'se' 
				AP 
				{
					_exprContent = "";
				} 
				expr
				OPREL 
				{ 
					_exprDecision = _exprContent;
					_exprDecision += _input.LT(-1).getText();
					_exprContent = "";
				} 
				expr
				{  
					_exprDecision += _exprContent; 
				}
				FP 

				'entao'
				ACH 
				{ 
					curThread = new ArrayList<AbstractCommand>();
					stack.push(curThread);
				}
				(cmd)+ 
				FCH 
				{ 
					listaTrue = stack.pop(); 
					listaFalse = null;
				}
				('senao' 
				ACH 
				{ 
					curThread = new ArrayList<AbstractCommand>();
					stack.push(curThread);
				}
				(cmd)+ 
				FCH
				{ 
					listaFalse = stack.pop();
				}
				)?
				{
					CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
					stack.peek().add(cmd);
				}
			;

cmdwhile	:	'enquanto'
				AP 
				{
					_exprContent = "";
				} 
				expr
				OPREL 
				{ 
					_exprDecision = _exprContent;
					_exprDecision += _input.LT(-1).getText();
					_exprContent = "";
				} 
				expr
				{  
					_exprDecision += _exprContent; 
				}
				FP
				ACH 
				{ 
					curThread = new ArrayList<AbstractCommand>();
					stack.push(curThread);
				}
				(cmd)+ 
				FCH
				{ 
					listaTrue = stack.pop(); 
					CommandWhile cmd = new CommandWhile(_exprDecision, listaTrue, false);
					stack.peek().add(cmd);
				}
			;

cmddowhile	:	'faca'
				ACH 
				{ 
					curThread = new ArrayList<AbstractCommand>();
					stack.push(curThread);
				}
				(cmd)+ 
				FCH
				'enquanto'
				AP 
				{
					_exprContent = "";
				} 
				expr
				OPREL 
				{ 
					_exprDecision = _exprContent;
					_exprDecision += _input.LT(-1).getText();
					_exprContent = "";
				} 
				expr
				{  
					_exprDecision += _exprContent; 
				}
				FP
				{ 
					listaTrue = stack.pop(); 
					CommandWhile cmd = new CommandWhile(_exprDecision, listaTrue, true);
					stack.peek().add(cmd);
				}
			;

forexpr 	:	ID 
				{	
					_exprContent = "";
					verificaIDDeclarado(_input.LT(-1).getText());
					_exprID = _input.LT(-1).getText();
					Variable leftVar = (Variable) symbolTable.get(_input.LT(-1).getText());
					leftDT = leftVar.getType();
					rightDT = -1;
				} 
				ATTR 
				expr
				{	
					Variable var = (Variable)symbolTable.get(_exprID);
					var.setValue(_exprContent);
				}
			;

cmdfor		:	'para'
				AP
				forexpr
				{
					_statement1 = new CommandAtribuicaoFor(_exprID,_exprContent);
				}
				SC
				{
					_exprContent = "";
				} 
				expr
				OPREL 
				{ 
					_statement2 = _exprContent;
					_statement2 += _input.LT(-1).getText();
					_exprContent = "";
				} 
				expr
				{
					_statement2 += _exprContent;
				}
				SC
				forexpr
				{
					_statement3 = new CommandAtribuicaoFor(_exprID,_exprContent);
				}
				FP
				'faca'
				ACH 
				{ 
					curThread = new ArrayList<AbstractCommand>();
					stack.push(curThread);
				}
				(cmd)+ 
				FCH
				{ 
					listaTrue = stack.pop(); 
					CommandFor cmd = new CommandFor(_statement1, _statement2, _statement3, listaTrue);
					stack.peek().add(cmd);
				}

			;
expr		:	termo
				'+' 
				{
					_exprContent += _input.LT(-1).getText();
				}
				expr | 
				termo 
				'-' 
				{
					_exprContent += _input.LT(-1).getText();
				} 
				expr | 
				termo
			;	

termo   	:	fator 
				'*' 
				{
					_exprContent += _input.LT(-1).getText();
				} 
				termo	| 
				fator 
				'/' 
				{
					_exprContent += _input.LT(-1).getText();
				} 
				termo | 
				fator
			;

fator		:	NUMBER 
				{	
					if (leftDT != 0) {
						throw new SemanticException("Type Mismatching");
					}
					_exprContent += _input.LT(-1).getText().replace(",", ".");
				} | 
				ID 	   
				{
					verificaIDDeclarado(_input.LT(-1).getText());
					Variable rightVar = (Variable) symbolTable.get(_input.LT(-1).getText()); 
					rightDT = rightVar.getType();
					if (leftDT != rightDT){
						throw new SemanticException("Type Mismatching");
					}
					setVariableUsage(_input.LT(-1).getText());
					_exprContent += _input.LT(-1).getText();
				} | 
				AP     
				{
					_exprContent += _input.LT(-1).getText();
				}
				expr 
				FP 
				{
					_exprContent += _input.LT(-1).getText();
				}
			;

exprText	: 	TEXTO 
				{
					if (leftDT != 1) {
						throw new RuntimeException("Type Mismatching");
					}
					_exprContent = _input.LT(-1).getText();
				}
			;

TEXTO 	  	:   ('"' (~'"')* '"');
AP		  	: 	'(';
FP 		  	: 	')';
PT		  	: 	'.';
SC		  	: 	';';
ATTR	  	: 	':=';
VIR		  	: 	',';
ACH		  	: 	'{';
FCH		  	: 	'}';
OPREL	  	: 	'>' | '<' | '>=' | '<=' | '==' | '!=';
ID 		  	: 	([a-z]|[A-Z]) ([a-z] | [A-Z] | [0-9])*;
NUMBER	  	: 	[0-9]+ (',' [0-9]+)?;
WS	      	: 	( ' ' | '	' | '\n' | '\r') -> skip;