package br.com.ufabc.mycompiler.ast;

import java.util.ArrayList;

public class CommandWhile extends AbstractCommand {

	private String condition;
	private ArrayList<AbstractCommand> list;
	private boolean doWhileStruct = false;
	
	public CommandWhile(String condition, ArrayList<AbstractCommand> list, boolean doWhileStruct) {
		this.condition = condition;
		this.list = list;
		this.doWhileStruct = doWhileStruct;
	}
	
	@Override
	public String toString() {
		return "CommandDecisao [condition=" + condition + ", list=" + list + "]";
	}

	@Override
	public String generateJavaCode() {
		StringBuilder str = new StringBuilder();
		
		if (doWhileStruct) {
			str.append("do {\n");
			for (AbstractCommand cmd: list) {
				str.append(cmd.generateJavaCode() + "\n");
			}
			str.append("} while (" + condition + ");");
		} else {
			str.append("while ("+condition+") { \n");
			for (AbstractCommand cmd: list) {
				str.append(cmd.generateJavaCode() + "\n");
			}
			str.append("};");			
		}
		
		return str.toString();
	}

}
