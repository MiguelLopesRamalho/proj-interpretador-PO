package pex.core;

import java.io.*;

public class Set extends BinaryExpression implements Visitable, Serializable {
	
	private Interpreter _interpreter;

	public Set(Expression e1, Expression e2, Interpreter interp) {
		super(e1, e2);
		_interpreter = interp;
	}

	public Interpreter getInterpreter() { return _interpreter; }

	public Literal evaluate(Visitor v) {
		return v.visit(this);
	}

	public String getAsText() {
		return ("(set " + this.getFirstArgument().getAsText() + " " + this.getSecondArgument().getAsText() + ")");
	}
}