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

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link IsiLangParser}.
 */
public interface IsiLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(IsiLangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(IsiLangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#declara}.
	 * @param ctx the parse tree
	 */
	void enterDeclara(IsiLangParser.DeclaraContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#declara}.
	 * @param ctx the parse tree
	 */
	void exitDeclara(IsiLangParser.DeclaraContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void enterDeclaravar(IsiLangParser.DeclaravarContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void exitDeclaravar(IsiLangParser.DeclaravarContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(IsiLangParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(IsiLangParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(IsiLangParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(IsiLangParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(IsiLangParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(IsiLangParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdleitura(IsiLangParser.CmdleituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdleitura(IsiLangParser.CmdleituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdescrita(IsiLangParser.CmdescritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdescrita(IsiLangParser.CmdescritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdexpr}.
	 * @param ctx the parse tree
	 */
	void enterCmdexpr(IsiLangParser.CmdexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdexpr}.
	 * @param ctx the parse tree
	 */
	void exitCmdexpr(IsiLangParser.CmdexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdif}.
	 * @param ctx the parse tree
	 */
	void enterCmdif(IsiLangParser.CmdifContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdif}.
	 * @param ctx the parse tree
	 */
	void exitCmdif(IsiLangParser.CmdifContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdwhile}.
	 * @param ctx the parse tree
	 */
	void enterCmdwhile(IsiLangParser.CmdwhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdwhile}.
	 * @param ctx the parse tree
	 */
	void exitCmdwhile(IsiLangParser.CmdwhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmddowhile}.
	 * @param ctx the parse tree
	 */
	void enterCmddowhile(IsiLangParser.CmddowhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmddowhile}.
	 * @param ctx the parse tree
	 */
	void exitCmddowhile(IsiLangParser.CmddowhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#forexpr}.
	 * @param ctx the parse tree
	 */
	void enterForexpr(IsiLangParser.ForexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#forexpr}.
	 * @param ctx the parse tree
	 */
	void exitForexpr(IsiLangParser.ForexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdfor}.
	 * @param ctx the parse tree
	 */
	void enterCmdfor(IsiLangParser.CmdforContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdfor}.
	 * @param ctx the parse tree
	 */
	void exitCmdfor(IsiLangParser.CmdforContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(IsiLangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(IsiLangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(IsiLangParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(IsiLangParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(IsiLangParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(IsiLangParser.FatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#exprText}.
	 * @param ctx the parse tree
	 */
	void enterExprText(IsiLangParser.ExprTextContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#exprText}.
	 * @param ctx the parse tree
	 */
	void exitExprText(IsiLangParser.ExprTextContext ctx);
}