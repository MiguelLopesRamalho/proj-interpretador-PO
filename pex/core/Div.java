package pex.core;

import java.io.*;

public class Div extends BinaryExpression implements Visitable, Serializable {

	public Div(Expression e1, Expression e2) {
		super(e1, e2);
	}

	public Literal evaluate(Visitor v) { 
		return v.visit(this);
	}

	public String getAsText() {
		return ("(div " + this.getFirstArgument().getAsText() + " " + this.getSecondArgument().getAsText() + ")");
	}
}