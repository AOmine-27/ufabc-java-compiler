// Generated from IsiLang.g4 by ANTLR 4.7.2
package br.com.ufabc.mycompiler.parser;

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

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsiLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, TEXTO=19, AP=20, FP=21, PT=22, SC=23, ATTR=24, VIR=25, ACH=26, 
		FCH=27, OPREL=28, ID=29, NUMBER=30, WS=31;
	public static final int
		RULE_prog = 0, RULE_declara = 1, RULE_declaravar = 2, RULE_tipo = 3, RULE_bloco = 4, 
		RULE_cmd = 5, RULE_cmdleitura = 6, RULE_cmdescrita = 7, RULE_cmdexpr = 8, 
		RULE_cmdif = 9, RULE_cmdwhile = 10, RULE_cmddowhile = 11, RULE_forexpr = 12, 
		RULE_cmdfor = 13, RULE_expr = 14, RULE_termo = 15, RULE_fator = 16, RULE_exprText = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "declara", "declaravar", "tipo", "bloco", "cmd", "cmdleitura", 
			"cmdescrita", "cmdexpr", "cmdif", "cmdwhile", "cmddowhile", "forexpr", 
			"cmdfor", "expr", "termo", "fator", "exprText"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog'", "'declare'", "'numero'", "'texto'", 
			"'leia'", "'escreva'", "'escrevaLn'", "'se'", "'entao'", "'senao'", "'enquanto'", 
			"'faca'", "'para'", "'+'", "'-'", "'*'", "'/'", null, "'('", "')'", "'.'", 
			"';'", "':='", "','", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "TEXTO", "AP", "FP", "PT", 
			"SC", "ATTR", "VIR", "ACH", "FCH", "OPREL", "ID", "NUMBER", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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
		private String _fullExpression;
		private ArrayList<AbstractCommand> listaTrue;
		private ArrayList<AbstractCommand> listaFalse;
		
		public void verificaIDDeclarado(String id) {
			if (!symbolTable.exists(id)) {
				throw new SemanticException("Symbol " + id + " not declared");
			}
		}

		public void verificaTipo(String id, String content) {
			int attribContentType;
			Variable storedVariable = (Variable) symbolTable.get(id);
			String regex = "[0-9]+|[0-9]+[,][0-9]+|";
			if (content.matches(regex)) {
				attribContentType = 0;
			} else {
				attribContentType = 1;
			}
			if (storedVariable.getType() != attribContentType) {
				if (attribContentType == 0) {
					throw new SemanticException("Cannot set value of type Number on variable " + id + " (Text)");
				} else {
					throw new SemanticException("Cannot set value of type Text on variable " + id + " (Number)");
				}
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
		
		public void exibeComandos() {
			for (AbstractCommand c: program.getComandos()) {
				System.out.println(c);
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

	public IsiLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public DeclaraContext declara() {
			return getRuleContext(DeclaraContext.class,0);
		}
		public TerminalNode PT() { return getToken(IsiLangParser.PT, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(T__0);
			setState(37);
			declara();
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << ID))) != 0)) {
				{
				setState(38);
				bloco();
				}
			}

			setState(41);
			match(T__1);
			 
								program.setVarTable(symbolTable);
								program.setComandos(stack.pop());
								checkUnusedVariables();
							
			setState(43);
			match(PT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaraContext extends ParserRuleContext {
		public List<DeclaravarContext> declaravar() {
			return getRuleContexts(DeclaravarContext.class);
		}
		public DeclaravarContext declaravar(int i) {
			return getRuleContext(DeclaravarContext.class,i);
		}
		public DeclaraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declara; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterDeclara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitDeclara(this);
		}
	}

	public final DeclaraContext declara() throws RecognitionException {
		DeclaraContext _localctx = new DeclaraContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declara);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(45);
				declaravar();
				}
				}
				setState(48); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaravarContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode PT() { return getToken(IsiLangParser.PT, 0); }
		public List<TerminalNode> VIR() { return getTokens(IsiLangParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(IsiLangParser.VIR, i);
		}
		public DeclaravarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaravar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterDeclaravar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitDeclaravar(this);
		}
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(T__2);
			setState(51);
			tipo();
			setState(52);
			match(ID);

								_varName = _input.LT(-1).getText();
								_varValue = null;
								symbol = new Variable(_varName, _tipo, _varValue);
								if (!symbolTable.exists(_varName)) {
									symbolTable.add(symbol);
								} else {
									throw new SemanticException("Symbol " + _varName + " already exists");
								}
								
							
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(54);
				match(VIR);
				setState(55);
				match(ID);

									_varName = _input.LT(-1).getText();
									_varValue = null;
									symbol = new Variable(_varName, _tipo, _varValue);
									if (!symbolTable.exists(_varName)) {
										symbolTable.add(symbol);
									} else {
										throw new SemanticException("Symbol " + _varName + " already exists");
									}
								
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
			match(PT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo);
		try {
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				match(T__3);

									_tipo = Variable.NUMBER;
								
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				match(T__4);

									_tipo = Variable.TEXT;
								
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public List<TerminalNode> PT() { return getTokens(IsiLangParser.PT); }
		public TerminalNode PT(int i) {
			return getToken(IsiLangParser.PT, i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

								curThread = new ArrayList<AbstractCommand>();
						 		stack.push(curThread);
							
			setState(74); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(71);
				cmd();
				setState(72);
				match(PT);
				}
				}
				setState(76); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << ID))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdContext extends ParserRuleContext {
		public CmdleituraContext cmdleitura() {
			return getRuleContext(CmdleituraContext.class,0);
		}
		public CmdescritaContext cmdescrita() {
			return getRuleContext(CmdescritaContext.class,0);
		}
		public CmdexprContext cmdexpr() {
			return getRuleContext(CmdexprContext.class,0);
		}
		public CmdifContext cmdif() {
			return getRuleContext(CmdifContext.class,0);
		}
		public CmdwhileContext cmdwhile() {
			return getRuleContext(CmdwhileContext.class,0);
		}
		public CmddowhileContext cmddowhile() {
			return getRuleContext(CmddowhileContext.class,0);
		}
		public CmdforContext cmdfor() {
			return getRuleContext(CmdforContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmd);
		try {
			setState(85);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				cmdleitura();
				}
				break;
			case T__6:
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				cmdescrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				cmdexpr();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 4);
				{
				setState(81);
				cmdif();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 5);
				{
				setState(82);
				cmdwhile();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 6);
				{
				setState(83);
				cmddowhile();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 7);
				{
				setState(84);
				cmdfor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdleituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public CmdleituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdleitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdleitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdleitura(this);
		}
	}

	public final CmdleituraContext cmdleitura() throws RecognitionException {
		CmdleituraContext _localctx = new CmdleituraContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(T__5);
			setState(88);
			match(AP);
			setState(89);
			match(ID);
				
								verificaIDDeclarado(_input.LT(-1).getText());
								_readID = _input.LT(-1).getText();
							
			setState(91);
			match(FP);

								Variable var = (Variable)symbolTable.get(_readID);
								var.setValue("");
								CommandLeitura cmd = new CommandLeitura(_readID, var);
								stack.peek().add(cmd);
							
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdescritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode TEXTO() { return getToken(IsiLangParser.TEXTO, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprTextContext exprText() {
			return getRuleContext(ExprTextContext.class,0);
		}
		public CmdescritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdescrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdescrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdescrita(this);
		}
	}

	public final CmdescritaContext cmdescrita() throws RecognitionException {
		CmdescritaContext _localctx = new CmdescritaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdescrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				{
				setState(94);
				match(T__6);

									_writeLn = false;
								
				}
				break;
			case T__7:
				{
				setState(96);
				match(T__7);
					
									_writeLn = true;
								
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(100);
			match(AP);
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(101);
				match(ID);

									verificaIDDeclarado(_input.LT(-1).getText());
									_writeID = _input.LT(-1).getText();
									checkVariableHasValue(_writeID);
									setVariableUsage(_writeID);
								
				}
				break;
			case 2:
				{
				setState(103);
				match(TEXTO);

									_writeID = _input.LT(-1).getText();
								
				}
				break;
			case 3:
				{

									_exprContent = "";
								
				setState(108);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case AP:
				case ID:
				case NUMBER:
					{
					setState(106);
					expr();
					}
					break;
				case TEXTO:
					{
					setState(107);
					exprText();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}

									_writeID = _exprContent;
								
				}
				break;
			}
			setState(114);
			match(FP);

								CommandEscrita cmd = new CommandEscrita(_writeID, _writeLn);
								stack.peek().add(cmd);
							
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdexprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode ATTR() { return getToken(IsiLangParser.ATTR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprTextContext exprText() {
			return getRuleContext(ExprTextContext.class,0);
		}
		public CmdexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdexpr(this);
		}
	}

	public final CmdexprContext cmdexpr() throws RecognitionException {
		CmdexprContext _localctx = new CmdexprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdexpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(ID);
				_fullExpression = "";
								verificaIDDeclarado(_input.LT(-1).getText());
			                  	_exprID = _input.LT(-1).getText();
								_fullExpression = _input.LT(-1).getText();
								Variable leftVar = (Variable) symbolTable.get(_input.LT(-1).getText());
								leftDT = leftVar.getType();
								rightDT = -1;
							
			setState(119);
			match(ATTR);

								_fullExpression += _input.LT(-1).getText();
								_exprContent = "";
							
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AP:
			case ID:
			case NUMBER:
				{
				setState(121);
				expr();
				}
				break;
			case TEXTO:
				{
				setState(122);
				exprText();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
				
								CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
								Variable var = (Variable)symbolTable.get(_exprID);
								var.setValue(_exprContent);
						  	  	stack.peek().add(cmd);
								_fullExpression += _exprContent;
							
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdifContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OPREL() { return getToken(IsiLangParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public List<TerminalNode> ACH() { return getTokens(IsiLangParser.ACH); }
		public TerminalNode ACH(int i) {
			return getToken(IsiLangParser.ACH, i);
		}
		public List<TerminalNode> FCH() { return getTokens(IsiLangParser.FCH); }
		public TerminalNode FCH(int i) {
			return getToken(IsiLangParser.FCH, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdif(this);
		}
	}

	public final CmdifContext cmdif() throws RecognitionException {
		CmdifContext _localctx = new CmdifContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdif);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(T__8);
			setState(128);
			match(AP);

								_exprContent = "";
							
			setState(130);
			expr();
			setState(131);
			match(OPREL);
			 
								_exprDecision = _exprContent;
								_exprDecision += _input.LT(-1).getText();
								_exprContent = "";
							
			setState(133);
			expr();
			  
								_exprDecision += _exprContent; 
							
			setState(135);
			match(FP);
			setState(136);
			match(T__9);
			setState(137);
			match(ACH);
			 
								curThread = new ArrayList<AbstractCommand>();
								stack.push(curThread);
							
			setState(140); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(139);
				cmd();
				}
				}
				setState(142); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << ID))) != 0) );
			setState(144);
			match(FCH);
			 
								listaTrue = stack.pop(); 
								listaFalse = null;
							
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(146);
				match(T__10);
				setState(147);
				match(ACH);
				 
									curThread = new ArrayList<AbstractCommand>();
									stack.push(curThread);
								
				setState(150); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(149);
					cmd();
					}
					}
					setState(152); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << ID))) != 0) );
				setState(154);
				match(FCH);
				 
									listaFalse = stack.pop();
								
				}
			}


								CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
								stack.peek().add(cmd);
							
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdwhileContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OPREL() { return getToken(IsiLangParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode ACH() { return getToken(IsiLangParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(IsiLangParser.FCH, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdwhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdwhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdwhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdwhile(this);
		}
	}

	public final CmdwhileContext cmdwhile() throws RecognitionException {
		CmdwhileContext _localctx = new CmdwhileContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdwhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(T__11);
			setState(162);
			match(AP);

								_exprContent = "";
							
			setState(164);
			expr();
			setState(165);
			match(OPREL);
			 
								_exprDecision = _exprContent;
								_exprDecision += _input.LT(-1).getText();
								_exprContent = "";
							
			setState(167);
			expr();
			  
								_exprDecision += _exprContent; 
							
			setState(169);
			match(FP);
			setState(170);
			match(ACH);
			 
								curThread = new ArrayList<AbstractCommand>();
								stack.push(curThread);
							
			setState(173); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(172);
				cmd();
				}
				}
				setState(175); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << ID))) != 0) );
			setState(177);
			match(FCH);
			 
								listaTrue = stack.pop(); 
								CommandWhile cmd = new CommandWhile(_exprDecision, listaTrue, false);
								stack.peek().add(cmd);
							
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmddowhileContext extends ParserRuleContext {
		public TerminalNode ACH() { return getToken(IsiLangParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(IsiLangParser.FCH, 0); }
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OPREL() { return getToken(IsiLangParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmddowhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmddowhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmddowhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmddowhile(this);
		}
	}

	public final CmddowhileContext cmddowhile() throws RecognitionException {
		CmddowhileContext _localctx = new CmddowhileContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cmddowhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(T__12);
			setState(181);
			match(ACH);
			 
								curThread = new ArrayList<AbstractCommand>();
								stack.push(curThread);
							
			setState(184); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(183);
				cmd();
				}
				}
				setState(186); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << ID))) != 0) );
			setState(188);
			match(FCH);
			setState(189);
			match(T__11);
			setState(190);
			match(AP);

								_exprContent = "";
							
			setState(192);
			expr();
			setState(193);
			match(OPREL);
			 
								_exprDecision = _exprContent;
								_exprDecision += _input.LT(-1).getText();
								_exprContent = "";
							
			setState(195);
			expr();
			  
								_exprDecision += _exprContent; 
							
			setState(197);
			match(FP);
			 
								listaTrue = stack.pop(); 
								CommandWhile cmd = new CommandWhile(_exprDecision, listaTrue, true);
								stack.peek().add(cmd);
							
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForexprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode ATTR() { return getToken(IsiLangParser.ATTR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ForexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterForexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitForexpr(this);
		}
	}

	public final ForexprContext forexpr() throws RecognitionException {
		ForexprContext _localctx = new ForexprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_forexpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(ID);
				
								_exprContent = "";
								verificaIDDeclarado(_input.LT(-1).getText());
								_exprID = _input.LT(-1).getText();
								_fullExpression = _input.LT(-1).getText();
								Variable leftVar = (Variable) symbolTable.get(_input.LT(-1).getText());
								leftDT = leftVar.getType();
								rightDT = -1;
							
			setState(202);
			match(ATTR);
			setState(203);
			expr();
				
								Variable var = (Variable)symbolTable.get(_exprID);
								var.setValue(_exprContent);
							
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdforContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public List<ForexprContext> forexpr() {
			return getRuleContexts(ForexprContext.class);
		}
		public ForexprContext forexpr(int i) {
			return getRuleContext(ForexprContext.class,i);
		}
		public List<TerminalNode> SC() { return getTokens(IsiLangParser.SC); }
		public TerminalNode SC(int i) {
			return getToken(IsiLangParser.SC, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OPREL() { return getToken(IsiLangParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode ACH() { return getToken(IsiLangParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(IsiLangParser.FCH, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdforContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdfor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdfor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdfor(this);
		}
	}

	public final CmdforContext cmdfor() throws RecognitionException {
		CmdforContext _localctx = new CmdforContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_cmdfor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(T__13);
			setState(207);
			match(AP);
			setState(208);
			forexpr();

								_statement1 = new CommandAtribuicaoFor(_exprID,_exprContent);
							
			setState(210);
			match(SC);

								_exprContent = "";
							
			setState(212);
			expr();
			setState(213);
			match(OPREL);
			 
								_statement2 = _exprContent;
								_statement2 += _input.LT(-1).getText();
								_exprContent = "";
							
			setState(215);
			expr();

								_statement2 += _exprContent;
							
			setState(217);
			match(SC);
			setState(218);
			forexpr();

								_statement3 = new CommandAtribuicaoFor(_exprID,_exprContent);
							
			setState(220);
			match(FP);
			setState(221);
			match(T__12);
			setState(222);
			match(ACH);
			 
								curThread = new ArrayList<AbstractCommand>();
								stack.push(curThread);
							
			setState(225); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(224);
				cmd();
				}
				}
				setState(227); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << ID))) != 0) );
			setState(229);
			match(FCH);
			 
								listaTrue = stack.pop(); 
								CommandFor cmd = new CommandFor(_statement1, _statement2, _statement3, listaTrue);
								stack.peek().add(cmd);
							
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expr);
		try {
			setState(243);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(232);
				termo();
				setState(233);
				match(T__14);

									_exprContent += _input.LT(-1).getText();
								
				setState(235);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(237);
				termo();
				setState(238);
				match(T__15);

									_exprContent += _input.LT(-1).getText();
								
				setState(240);
				expr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(242);
				termo();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermoContext extends ParserRuleContext {
		public FatorContext fator() {
			return getRuleContext(FatorContext.class,0);
		}
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_termo);
		try {
			setState(256);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(245);
				fator();
				setState(246);
				match(T__16);

									_exprContent += _input.LT(-1).getText();
								
				setState(248);
				termo();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(250);
				fator();
				setState(251);
				match(T__17);

									_exprContent += _input.LT(-1).getText();
								
				setState(253);
				termo();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(255);
				fator();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FatorContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterFator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitFator(this);
		}
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_fator);
		try {
			setState(268);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(258);
				match(NUMBER);
					
									if (leftDT != 0) {
										throw new SemanticException("Type Mismatching");
									}
									_exprContent += _input.LT(-1).getText().replace(",", ".");
								
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(260);
				match(ID);

									verificaIDDeclarado(_input.LT(-1).getText());
									Variable rightVar = (Variable) symbolTable.get(_input.LT(-1).getText()); 
									rightDT = rightVar.getType();
									if (leftDT != rightDT){
										throw new SemanticException("Type Mismatching");
									}
									setVariableUsage(_input.LT(-1).getText());
									_exprContent += _input.LT(-1).getText();
								
				}
				break;
			case AP:
				enterOuterAlt(_localctx, 3);
				{
				setState(262);
				match(AP);

									_exprContent += _input.LT(-1).getText();
								
				setState(264);
				expr();
				setState(265);
				match(FP);

									_exprContent += _input.LT(-1).getText();
								
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprTextContext extends ParserRuleContext {
		public TerminalNode TEXTO() { return getToken(IsiLangParser.TEXTO, 0); }
		public ExprTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterExprText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitExprText(this);
		}
	}

	public final ExprTextContext exprText() throws RecognitionException {
		ExprTextContext _localctx = new ExprTextContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_exprText);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(TEXTO);

								if (leftDT != 1) {
									throw new RuntimeException("Type Mismatching");
								}
								_exprContent = _input.LT(-1).getText();
							
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u0114\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\5\2*\n\2\3\2\3\2\3\2\3\2\3\3\6\3\61\n\3\r\3\16"+
		"\3\62\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4<\n\4\f\4\16\4?\13\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\5\5G\n\5\3\6\3\6\3\6\3\6\6\6M\n\6\r\6\16\6N\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\5\7X\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\5"+
		"\te\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\to\n\t\3\t\3\t\5\ts\n\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\5\n~\n\n\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\6\13\u008f\n\13\r\13\16"+
		"\13\u0090\3\13\3\13\3\13\3\13\3\13\3\13\6\13\u0099\n\13\r\13\16\13\u009a"+
		"\3\13\3\13\3\13\5\13\u00a0\n\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\6\f\u00b0\n\f\r\f\16\f\u00b1\3\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\r\6\r\u00bb\n\r\r\r\16\r\u00bc\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\6\17\u00e4\n\17\r\17\16\17\u00e5\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00f6\n\20\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0103\n\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u010f\n\22\3\23\3\23\3\23\3\23\2\2"+
		"\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\2\2\u011d\2&\3\2\2\2"+
		"\4\60\3\2\2\2\6\64\3\2\2\2\bF\3\2\2\2\nH\3\2\2\2\fW\3\2\2\2\16Y\3\2\2"+
		"\2\20d\3\2\2\2\22w\3\2\2\2\24\u0081\3\2\2\2\26\u00a3\3\2\2\2\30\u00b6"+
		"\3\2\2\2\32\u00ca\3\2\2\2\34\u00d0\3\2\2\2\36\u00f5\3\2\2\2 \u0102\3\2"+
		"\2\2\"\u010e\3\2\2\2$\u0110\3\2\2\2&\'\7\3\2\2\')\5\4\3\2(*\5\n\6\2)("+
		"\3\2\2\2)*\3\2\2\2*+\3\2\2\2+,\7\4\2\2,-\b\2\1\2-.\7\30\2\2.\3\3\2\2\2"+
		"/\61\5\6\4\2\60/\3\2\2\2\61\62\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63"+
		"\5\3\2\2\2\64\65\7\5\2\2\65\66\5\b\5\2\66\67\7\37\2\2\67=\b\4\1\289\7"+
		"\33\2\29:\7\37\2\2:<\b\4\1\2;8\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>"+
		"@\3\2\2\2?=\3\2\2\2@A\7\30\2\2A\7\3\2\2\2BC\7\6\2\2CG\b\5\1\2DE\7\7\2"+
		"\2EG\b\5\1\2FB\3\2\2\2FD\3\2\2\2G\t\3\2\2\2HL\b\6\1\2IJ\5\f\7\2JK\7\30"+
		"\2\2KM\3\2\2\2LI\3\2\2\2MN\3\2\2\2NL\3\2\2\2NO\3\2\2\2O\13\3\2\2\2PX\5"+
		"\16\b\2QX\5\20\t\2RX\5\22\n\2SX\5\24\13\2TX\5\26\f\2UX\5\30\r\2VX\5\34"+
		"\17\2WP\3\2\2\2WQ\3\2\2\2WR\3\2\2\2WS\3\2\2\2WT\3\2\2\2WU\3\2\2\2WV\3"+
		"\2\2\2X\r\3\2\2\2YZ\7\b\2\2Z[\7\26\2\2[\\\7\37\2\2\\]\b\b\1\2]^\7\27\2"+
		"\2^_\b\b\1\2_\17\3\2\2\2`a\7\t\2\2ae\b\t\1\2bc\7\n\2\2ce\b\t\1\2d`\3\2"+
		"\2\2db\3\2\2\2ef\3\2\2\2fr\7\26\2\2gh\7\37\2\2hs\b\t\1\2ij\7\25\2\2js"+
		"\b\t\1\2kn\b\t\1\2lo\5\36\20\2mo\5$\23\2nl\3\2\2\2nm\3\2\2\2op\3\2\2\2"+
		"pq\b\t\1\2qs\3\2\2\2rg\3\2\2\2ri\3\2\2\2rk\3\2\2\2st\3\2\2\2tu\7\27\2"+
		"\2uv\b\t\1\2v\21\3\2\2\2wx\7\37\2\2xy\b\n\1\2yz\7\32\2\2z}\b\n\1\2{~\5"+
		"\36\20\2|~\5$\23\2}{\3\2\2\2}|\3\2\2\2~\177\3\2\2\2\177\u0080\b\n\1\2"+
		"\u0080\23\3\2\2\2\u0081\u0082\7\13\2\2\u0082\u0083\7\26\2\2\u0083\u0084"+
		"\b\13\1\2\u0084\u0085\5\36\20\2\u0085\u0086\7\36\2\2\u0086\u0087\b\13"+
		"\1\2\u0087\u0088\5\36\20\2\u0088\u0089\b\13\1\2\u0089\u008a\7\27\2\2\u008a"+
		"\u008b\7\f\2\2\u008b\u008c\7\34\2\2\u008c\u008e\b\13\1\2\u008d\u008f\5"+
		"\f\7\2\u008e\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u008e\3\2\2\2\u0090"+
		"\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\7\35\2\2\u0093\u009f\b"+
		"\13\1\2\u0094\u0095\7\r\2\2\u0095\u0096\7\34\2\2\u0096\u0098\b\13\1\2"+
		"\u0097\u0099\5\f\7\2\u0098\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u0098"+
		"\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d\7\35\2\2"+
		"\u009d\u009e\b\13\1\2\u009e\u00a0\3\2\2\2\u009f\u0094\3\2\2\2\u009f\u00a0"+
		"\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\b\13\1\2\u00a2\25\3\2\2\2\u00a3"+
		"\u00a4\7\16\2\2\u00a4\u00a5\7\26\2\2\u00a5\u00a6\b\f\1\2\u00a6\u00a7\5"+
		"\36\20\2\u00a7\u00a8\7\36\2\2\u00a8\u00a9\b\f\1\2\u00a9\u00aa\5\36\20"+
		"\2\u00aa\u00ab\b\f\1\2\u00ab\u00ac\7\27\2\2\u00ac\u00ad\7\34\2\2\u00ad"+
		"\u00af\b\f\1\2\u00ae\u00b0\5\f\7\2\u00af\u00ae\3\2\2\2\u00b0\u00b1\3\2"+
		"\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\u00b4\7\35\2\2\u00b4\u00b5\b\f\1\2\u00b5\27\3\2\2\2\u00b6\u00b7\7\17"+
		"\2\2\u00b7\u00b8\7\34\2\2\u00b8\u00ba\b\r\1\2\u00b9\u00bb\5\f\7\2\u00ba"+
		"\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2"+
		"\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\7\35\2\2\u00bf\u00c0\7\16\2\2\u00c0"+
		"\u00c1\7\26\2\2\u00c1\u00c2\b\r\1\2\u00c2\u00c3\5\36\20\2\u00c3\u00c4"+
		"\7\36\2\2\u00c4\u00c5\b\r\1\2\u00c5\u00c6\5\36\20\2\u00c6\u00c7\b\r\1"+
		"\2\u00c7\u00c8\7\27\2\2\u00c8\u00c9\b\r\1\2\u00c9\31\3\2\2\2\u00ca\u00cb"+
		"\7\37\2\2\u00cb\u00cc\b\16\1\2\u00cc\u00cd\7\32\2\2\u00cd\u00ce\5\36\20"+
		"\2\u00ce\u00cf\b\16\1\2\u00cf\33\3\2\2\2\u00d0\u00d1\7\20\2\2\u00d1\u00d2"+
		"\7\26\2\2\u00d2\u00d3\5\32\16\2\u00d3\u00d4\b\17\1\2\u00d4\u00d5\7\31"+
		"\2\2\u00d5\u00d6\b\17\1\2\u00d6\u00d7\5\36\20\2\u00d7\u00d8\7\36\2\2\u00d8"+
		"\u00d9\b\17\1\2\u00d9\u00da\5\36\20\2\u00da\u00db\b\17\1\2\u00db\u00dc"+
		"\7\31\2\2\u00dc\u00dd\5\32\16\2\u00dd\u00de\b\17\1\2\u00de\u00df\7\27"+
		"\2\2\u00df\u00e0\7\17\2\2\u00e0\u00e1\7\34\2\2\u00e1\u00e3\b\17\1\2\u00e2"+
		"\u00e4\5\f\7\2\u00e3\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e3\3\2"+
		"\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\7\35\2\2\u00e8"+
		"\u00e9\b\17\1\2\u00e9\35\3\2\2\2\u00ea\u00eb\5 \21\2\u00eb\u00ec\7\21"+
		"\2\2\u00ec\u00ed\b\20\1\2\u00ed\u00ee\5\36\20\2\u00ee\u00f6\3\2\2\2\u00ef"+
		"\u00f0\5 \21\2\u00f0\u00f1\7\22\2\2\u00f1\u00f2\b\20\1\2\u00f2\u00f3\5"+
		"\36\20\2\u00f3\u00f6\3\2\2\2\u00f4\u00f6\5 \21\2\u00f5\u00ea\3\2\2\2\u00f5"+
		"\u00ef\3\2\2\2\u00f5\u00f4\3\2\2\2\u00f6\37\3\2\2\2\u00f7\u00f8\5\"\22"+
		"\2\u00f8\u00f9\7\23\2\2\u00f9\u00fa\b\21\1\2\u00fa\u00fb\5 \21\2\u00fb"+
		"\u0103\3\2\2\2\u00fc\u00fd\5\"\22\2\u00fd\u00fe\7\24\2\2\u00fe\u00ff\b"+
		"\21\1\2\u00ff\u0100\5 \21\2\u0100\u0103\3\2\2\2\u0101\u0103\5\"\22\2\u0102"+
		"\u00f7\3\2\2\2\u0102\u00fc\3\2\2\2\u0102\u0101\3\2\2\2\u0103!\3\2\2\2"+
		"\u0104\u0105\7 \2\2\u0105\u010f\b\22\1\2\u0106\u0107\7\37\2\2\u0107\u010f"+
		"\b\22\1\2\u0108\u0109\7\26\2\2\u0109\u010a\b\22\1\2\u010a\u010b\5\36\20"+
		"\2\u010b\u010c\7\27\2\2\u010c\u010d\b\22\1\2\u010d\u010f\3\2\2\2\u010e"+
		"\u0104\3\2\2\2\u010e\u0106\3\2\2\2\u010e\u0108\3\2\2\2\u010f#\3\2\2\2"+
		"\u0110\u0111\7\25\2\2\u0111\u0112\b\23\1\2\u0112%\3\2\2\2\25)\62=FNWd"+
		"nr}\u0090\u009a\u009f\u00b1\u00bc\u00e5\u00f5\u0102\u010e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}