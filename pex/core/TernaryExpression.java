package pex.core;

public abstract class TernaryExpression extends CompositeExpression{
	
	private Expression _expression1;
	private Expression _expression2;
	private Expression _expression3;

	public TernaryExpression(Expression e1, Expression e2, Expression e3) {
		_expression1 = e1;
		_expression2 = e2;
		_expression3 = e3;
	}

	public Expression getFirstArgument(){
		return _expression1;
	}	

	public Expression getSecondArgument(){
		return _expression2;
	}

	public Expression getThirdArgument(){
		return _expression3;
	}
}