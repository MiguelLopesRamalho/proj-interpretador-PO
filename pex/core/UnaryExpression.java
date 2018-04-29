package pex.core;

public abstract class UnaryExpression extends CompositeExpression{

	private Expression _expression;

	public UnaryExpression(Expression e) {
		_expression = e;
	}

	public Expression getFirstArgument(){
		return _expression;
	}
} 