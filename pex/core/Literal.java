package pex.core;

public abstract class Literal extends Expression implements Visitable {
	
	public Literal evaluate(Visitor v) { return v.visit(this); }

}