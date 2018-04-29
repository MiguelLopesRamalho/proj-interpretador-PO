package pex.core;

import java.io.*;

public class Neg extends UnaryExpression implements Visitable, Serializable {
	
	public Neg(Expression e) {
		super(e);
	}

	public Literal evaluate(Visitor v) {
		return v.visit(this);
	}

	public String getAsText() {
		return ("(neg " + this.getFirstArgument().getAsText() + ")");
	}
}