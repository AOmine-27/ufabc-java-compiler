package br.com.ufabc.mycompiler.ast;

import br.com.ufabc.mycompiler.datastructures.Variable;

public class CommandLeitura extends AbstractCommand{

	private String id;
	private Variable var;
	
	public CommandLeitura(String id, Variable var) {
		this.id = id;
		this.var = var;
	}
	
	@Override
	public String toString() {
		return "CommandLeitura [id=" + id + "]";
	}

	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		return id + "= _key." + (var.getType()==Variable.NUMBER? "nextDouble();" : "nextLine();");
	}

}
