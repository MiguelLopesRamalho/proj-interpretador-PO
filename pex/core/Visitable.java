package pex.core;

public interface Visitable {
	
	public Expression evaluate(Visitor visitor);
	
}