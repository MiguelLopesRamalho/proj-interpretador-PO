package pex.core;

public abstract class BinaryExpression extends CompositeExpression{
	
	private Expression _expression1;
	private Expression _expression2;

	public BinaryExpression(Expression e1, Expression e2) {
		_expression1 = e1;
		_expression2 = e2;
	}

	public Expression getFirstArgument(){
		return _expression1;
	}

	public Expression getSecondArgument(){
		return _expression2;
	}
}