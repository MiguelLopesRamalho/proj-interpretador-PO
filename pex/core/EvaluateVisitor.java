package pex.core;

import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.Display;


public class EvaluateVisitor implements Visitor {
	
	public Literal visit(Add add) {
		Literal first = add.getFirstArgument().evaluate(this);
		Literal second = add.getSecondArgument().evaluate(this); 
		return new IntegerLiteral(((IntegerLiteral) first).getValue() + ((IntegerLiteral) second).getValue());
	}

	public Literal visit(Mul mul) {
		Literal first = mul.getFirstArgument().evaluate(this);
		Literal second = mul.getSecondArgument().evaluate(this); 
		return new IntegerLiteral(((IntegerLiteral) first).getValue() * ((IntegerLiteral) second).getValue());
	}

	public Literal visit(Sub sub) {
		Literal first = sub.getFirstArgument().evaluate(this);
		Literal second = sub.getSecondArgument().evaluate(this); 
		return new IntegerLiteral(((IntegerLiteral) first).getValue() - ((IntegerLiteral) second).getValue());
	}

	public Literal visit(Div div) {
		Literal first = div.getFirstArgument().evaluate(this);
		Literal second = div.getSecondArgument().evaluate(this); 
		return new IntegerLiteral(((IntegerLiteral) first).getValue() / ((IntegerLiteral) second).getValue());
	}

	public Literal visit(Mod mod) {
		Literal first = mod.getFirstArgument().evaluate(this);
		Literal second = mod.getSecondArgument().evaluate(this); 
		return new IntegerLiteral(((IntegerLiteral) first).getValue() % ((IntegerLiteral) second).getValue());
	}

	public Literal visit(Literal literal) {
		if(literal instanceof IntegerLiteral)
			return new IntegerLiteral(((IntegerLiteral) literal).getValue());

		else
			return new StringLiteral(((StringLiteral) literal).getValue());
	}

	public Literal visit(Lt lt) {
		Literal first = lt.getFirstArgument().evaluate(this);
		Literal second = lt.getSecondArgument().evaluate(this);
		if(((IntegerLiteral) first).getValue() < ((IntegerLiteral) second).getValue())
			return new IntegerLiteral(1);
		return new IntegerLiteral(0);
	}

	public Literal visit(Le le) {
		Literal first = le.getFirstArgument().evaluate(this);
		Literal second = le.getSecondArgument().evaluate(this);
		if(((IntegerLiteral) first).getValue() <= ((IntegerLiteral) second).getValue())
			return new IntegerLiteral(1);
		return new IntegerLiteral(0);
	}

	public Literal visit(Ge ge) {
		Literal first = ge.getFirstArgument().evaluate(this);
		Literal second = ge.getSecondArgument().evaluate(this);
		if(((IntegerLiteral) first).getValue() >= ((IntegerLiteral) second).getValue())
			return new IntegerLiteral(1);
		return new IntegerLiteral(0);
	}

	public Literal visit(Gt gt) {
		Literal first = gt.getFirstArgument().evaluate(this);
		Literal second = gt.getSecondArgument().evaluate(this);
		if(((IntegerLiteral) first).getValue() > ((IntegerLiteral) second).getValue())
			return new IntegerLiteral(1);
		return new IntegerLiteral(0);
	}

	public Literal visit(Eq eq) {
		Literal first = eq.getFirstArgument().evaluate(this);
		Literal second = eq.getSecondArgument().evaluate(this);
		if(((IntegerLiteral) first).getValue() == ((IntegerLiteral) second).getValue())
			return new IntegerLiteral(1);
		return new IntegerLiteral(0);
	}

	public Literal visit(Ne ne) {
		Literal first = ne.getFirstArgument().evaluate(this);
		Literal second = ne.getSecondArgument().evaluate(this);
		if(((IntegerLiteral) first).getValue() != ((IntegerLiteral) second).getValue())
			return new IntegerLiteral(1);
		return new IntegerLiteral(0);
	}

	public Literal visit(Neg neg) {
		Literal first = neg.getFirstArgument().evaluate(this);
		return new IntegerLiteral(((IntegerLiteral) first).getValue() * -1);
	}

	public Literal visit(Not not) {
		Literal first = not.getFirstArgument().evaluate(this);
		if(((IntegerLiteral) first).getValue() != 0)
			return new IntegerLiteral(0);
		return new IntegerLiteral(1);
	}

	public Literal visit(And and) {
		if(((IntegerLiteral) and.getFirstArgument().evaluate(this)).getValue() != 0) {
			if(((IntegerLiteral) and.getSecondArgument().evaluate(this)).getValue() != 0)
				return new IntegerLiteral(1);
		}
		return new IntegerLiteral(0); 
	}

	public Literal visit(Or or) {

		if(((IntegerLiteral) or.getFirstArgument().evaluate(this)).getValue() == 0) {
			if(((IntegerLiteral) or.getSecondArgument().evaluate(this)).getValue() == 0)
				return new IntegerLiteral(0);
		}
		return new IntegerLiteral(1);
	}

	public Literal visit(Seq seq) {
		for(int i = 0; i < seq.getArguments().size()-1 ; i++) {
			seq.getArguments().get(i).evaluate(this);
		}

		Literal last = seq.getArguments().get(seq.getArguments().size() - 1).evaluate(this);
		return last;
		
	}

	public Literal visit(Print print) { 
		Display d = new Display();

		for(int i = 0; i < print.getArguments().size()-1 ; i++) {
			Literal aux = print.getArguments().get(i).evaluate(this);
			if(aux instanceof IntegerLiteral)
				d.add(((IntegerLiteral) aux).getAsText());
			else
				d.add(((StringLiteral) aux).getValue());
		}

		Literal last = print.getArguments().get(print.getArguments().size() - 1).evaluate(this);
		if(last instanceof IntegerLiteral)
			d.add(((IntegerLiteral) last).getAsText());
		else
			d.add(((StringLiteral) last).getValue());
		d.display();

		if(last instanceof IntegerLiteral)
			return new IntegerLiteral(((IntegerLiteral) last).getValue());
		return new StringLiteral(((StringLiteral) last).getValue());
		
	}

	public Literal visit(ReadI readi) { 
        return new IntegerLiteral(readi.getInterp().getAppIO().readInteger());
    }

    public Literal visit(ReadS reads) { 
        return new StringLiteral(reads.getInterp().getAppIO().readString());
    }

    public Literal visit(If if1) {

		if(((IntegerLiteral) if1.getFirstArgument().evaluate(this)).getValue() != 0) 
			return if1.getSecondArgument().evaluate(this);
		else
			return if1.getThirdArgument().evaluate(this);
    }

    public Literal visit(While while1) {
    	while(((IntegerLiteral)while1.getFirstArgument().evaluate(this)).getValue() != 0){
    		while1.getSecondArgument().evaluate(this);
    	}

    	return ((IntegerLiteral)while1.getFirstArgument().evaluate(this));

    }

    public Literal visit(Identifier id) { //avaliaçao do identificador corresponde a obtencao do seu valor
   		//may need if(contains) 
       	return id.getInterpreter().getIdMap().getValue(id.getName());

	}	

	public Literal visit(Set set) { 
		
		//sacar id e literal a adicionar
		String name = set.getFirstArgument().getAsText();
		Literal value = set.getSecondArgument().evaluate(this);
		//adicionar
		set.getInterpreter().getIdMap().addPair(name, value);
		return value;

    }

    public Literal visit(Call call) { 
    	Literal first = call.getFirstArgument().evaluate(this);
    	String progName = (((StringLiteral) first).getValue());
    	return call.getInterpreter().getProgram(progName).execute();
    }
}