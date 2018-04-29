package pex.core;

public interface Visitor {

	public Literal visit(Literal literal); 
	
	public Literal visit(Identifier identifier);

	public Literal visit(Add add);
 	
	public Literal visit(Div div);

	public Literal visit(Mul mul);

	public Literal visit(Mod mod);

	public Literal visit(Sub sub);

	public Literal visit(Lt lt);

	public Literal visit(Le le);

	public Literal visit(Gt gt);

	public Literal visit(Ge ge);

	public Literal visit(Eq eq);

	public Literal visit(Ne ne);

	public Literal visit(Neg neg);

	public Literal visit(Not not);

	public Literal visit(And and);

	public Literal visit(Or or);

	public Literal visit(Seq seq);

	public Literal visit(Print print);

	public Literal visit(ReadI readi);

	public Literal visit(ReadS reads);

	public Literal visit(If if1);

	public Literal visit(While while1);

	public Literal visit(Call call);

	public Literal visit(Set set);
	
}