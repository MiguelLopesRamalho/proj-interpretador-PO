package pex.app.evaluator;

import pex.core.*;

import pt.utl.ist.po.ui.Display;


/**
 * Show program (present code).
 */
public class ShowProgram extends ProgramCommand {

    /**
     * @param receiver
     */
    public ShowProgram(Program receiver) {
        super(Label.SHOW_PROGRAM, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {
        
        Display d = new Display();

        for(Expression e: entity().getList()) {
            d.add(e.getAsText() + "\n");
        }

        d.display();
    }
}
