package pex.core;

import java.io.*;

public class ReadI extends CompositeExpression implements Visitable, Serializable {
	
	private Expression expression;
	private Interpreter _interp; 

	public ReadI(Interpreter interp){
		_interp = interp;
	}

	public Literal evaluate(Visitor v) {
		return v.visit(this);
	}

	public Interpreter getInterp(){
		return _interp;
	}	

	public String getAsText() { return "(readi)"; }
}