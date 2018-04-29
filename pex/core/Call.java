package pex.core;

import java.io.*;

public class Call extends UnaryExpression implements Visitable, Serializable {
	
	private Interpreter _interpreter;

	public Call(Expression e, Interpreter interp) {
		super(e);
		_interpreter = interp;
	}

	public Interpreter getInterpreter() { return _interpreter; }

	public Literal evaluate(Visitor v) {
		return v.visit(this);
	}

	public String getAsText() {
		return ("(call " + this.getFirstArgument().getAsText() + ")");
	}
}