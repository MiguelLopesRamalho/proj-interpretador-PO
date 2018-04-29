package pex.app.evaluator;

import pex.app.BadExpressionException;
import pex.app.BadPositionException;
import pex.parser.BadSourceException;
import pex.parser.ParserException;

import pex.core.*;

import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;

/**
 * Add expression.
 */
public class AddExpression extends ProgramCommand {
    /**
     * @param receiver
     */
    public AddExpression(Program receiver) {
        super(Label.ADD_EXPRESSION, receiver);
    }
    
    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() throws BadExpressionException, BadPositionException {
        
    Form f = new Form();
    InputInteger i = new InputInteger(f, Message.requestPosition());
    f.parse();
    int position = i.value();

    Form f2 = new Form();
    InputString s = new InputString(f2, Message.requestExpression());
    f2.parse();
    String expression = s.value();

    try {
        Expression exp = entity().getParser().parseString(expression, entity()); 
        entity().addExpression(position, exp);
    } 

    catch (ParserException pe) {
        throw new BadExpressionException(expression);   
        }
    }
}