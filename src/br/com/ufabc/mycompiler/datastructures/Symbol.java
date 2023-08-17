package br.com.ufabc.mycompiler.datastructures;

public abstract class Symbol {
	
	protected String name;
	protected boolean isUsed;
	
	public abstract String generateJavaCode();
	
	public Symbol(String name) {
		this.name = name;
		this.isUsed = false;
	}
	
	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Symbol [name = " + name + "]";
	}
}
