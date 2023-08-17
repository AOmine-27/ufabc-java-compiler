package br.com.ufabc.mycompiler.ast;

import java.util.ArrayList;

public class CommandFor  extends AbstractCommand {
	
	private CommandAtribuicaoFor s1, s3;
	private String s2;
	private ArrayList<AbstractCommand> commandList;
	
	public CommandFor(CommandAtribuicaoFor statement1, String statement2, CommandAtribuicaoFor statement3, ArrayList<AbstractCommand> commandList) {
		this.s1 = statement1;
		this.s2 = statement2;
		this.s3 = statement3;
		this.commandList = commandList;
	}
	
	@Override
	public String toString() {
		return "CommandFor [statement1 = " + s1.generateJavaCode() + ", statement 2 = " + s2 + ", statement 3 = "+ s3.generateJavaCode() + ", list=" + commandList + "]";
	}

	@Override
	public String generateJavaCode() {
		StringBuilder str = new StringBuilder();
		
		str.append("for(" + s1.generateJavaCode() + "; " + s2 + "; " + s3.generateJavaCode() + ") {\n");
		for (AbstractCommand cmd: commandList) {
			str.append(cmd.generateJavaCode() + "\n");
		}
		str.append("};\n");	
		
		return str.toString();
	}
}
