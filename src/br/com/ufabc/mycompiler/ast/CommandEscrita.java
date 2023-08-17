package br.com.ufabc.mycompiler.ast;

public class CommandEscrita extends AbstractCommand {
	
	private String id;
	private boolean printNewLine = false;
	
	public CommandEscrita(String id, boolean printNewLine) {
		this.id = id;
		this.printNewLine = printNewLine;
	}
	
	@Override
	public String toString() {
		return "CommandEscrita [id=" + id + "]";
	}

	@Override
	public String generateJavaCode() {
		if (printNewLine) {
			return "System.out.println(" + id + ");";
		} else {
			return "System.out.print(" + id + ");";
		}
		
	}

}
