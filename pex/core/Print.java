package pex.core;

import java.util.*;
import java.io.*;

public class Print extends VariadicExpression implements Visitable, Serializable {
	
	private Interpreter _interp;


	public Print(ArrayList<Expression> args, Interpreter interp) {
		super(args);
		_interp = interp;
	}

	public Literal evaluate(Visitor v) {
		return v.visit(this);
	}

	public String getAsText() {
		String output = "(print";
		
		for(int i = 0; i < this.getArguments().size(); i++) {
			output += " " + this.getArguments().get(i).getAsText();
		}
		output += ")";
		return output;
	}

	public Interpreter getInterp(){
		return _interp;
	}
}