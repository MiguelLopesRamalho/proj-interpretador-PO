package pex.core;

import java.io.*;

public class If extends TernaryExpression implements Visitable, Serializable {
	
	public If(Expression e1, Expression e2, Expression e3) {
		super(e1, e2, e3);
	}
	
	public Literal evaluate(Visitor v) {
		return v.visit(this);
	}

	public String getAsText() {
		return ("(if " + this.getFirstArgument().getAsText() + " " + this.getSecondArgument().getAsText() + " " + this.getThirdArgument().getAsText() + ")");
	}
}