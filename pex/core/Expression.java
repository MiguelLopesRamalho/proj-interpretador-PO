package pex.core;

public abstract class Expression {
	
	public abstract String getAsText();

	public abstract Literal evaluate(Visitor v);
}