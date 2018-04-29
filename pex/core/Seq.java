package pex.core;

import java.util.*;
import java.io.*;

public class Seq extends VariadicExpression implements Visitable, Serializable{
	
	public Seq(ArrayList<Expression> args) {
		super(args);
	}

	public Literal evaluate(Visitor v) {
		return v.visit(this);
	}

	public String getAsText() {
		String output = "(seq";
		for(Expression e: this.getArguments()){
			output += " " + e.getAsText();
		}
		output += ")";
	return output;
	}
}