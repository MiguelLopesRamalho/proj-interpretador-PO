package pex.core;

import java.io.*;

public class ReadS extends CompositeExpression implements Visitable, Serializable {
	
	private Interpreter _interp;

	public ReadS(Interpreter interp) {
		_interp = interp;
	}

	public Literal evaluate(Visitor v) {
		return v.visit(this);
	}

	public Interpreter getInterp(){
		return _interp;
	}

	public String getAsText() { return "(reads)"; }
}