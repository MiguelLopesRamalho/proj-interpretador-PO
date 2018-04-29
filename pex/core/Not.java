package pex.core;

import java.io.*;

public class Not extends UnaryExpression implements Visitable, Serializable {
	
	public Not(Expression e) {
		super(e);
	}

	public Literal evaluate(Visitor v) {
		return v.visit(this);
	}

	public String getAsText() {
		return ("(not " + this.getFirstArgument().getAsText() + ")");
	}
}