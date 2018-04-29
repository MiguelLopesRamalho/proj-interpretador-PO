package pex.core;

import java.io.*;

public class Identifier extends Expression implements Serializable , Visitable {
	
	private String _name;
	private Interpreter _interp;

	public Identifier(String name, Interpreter interp) {
		_name = name;
		_interp = interp;
	}

	public void setName(String name) { _name = name; }

	public String getName() { return _name; }

	public void setInterpreter(Interpreter interp) { _interp = interp; }

	public Interpreter getInterpreter() { return _interp; }

	public String getAsText() { return _name; }

	public Literal evaluate(Visitor v)  {
		return v.visit(this);
	}		

}