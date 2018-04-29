package pex.core;

import java.io.*;

public class Eq extends BinaryExpression implements Visitable, Serializable {
	
	public Eq(Expression e1, Expression e2) {
		super(e1, e2);
	}

	public Literal evaluate(Visitor v) {
		return v.visit(this);
	}

	public String getAsText() {
		return ("(eq " + this.getFirstArgument().getAsText() + " " + this.getSecondArgument().getAsText() + ")");
	}
}