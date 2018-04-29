package pex.core;

import java.util.*;
import java.io.*;

public abstract class VariadicExpression extends CompositeExpression{
	
	private List<Expression> _expressions;

	public VariadicExpression(ArrayList<Expression> args) {
		_expressions = args;
	}

	public List<Expression> getArguments(){
		return _expressions;
	}
}