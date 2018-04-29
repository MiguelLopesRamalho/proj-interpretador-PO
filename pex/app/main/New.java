package pex.app.main;

import pex.core.*;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputBoolean;

/**
 * Command for creating a new interpreter.
 */
public class New extends Command<AppInterpreter> {
    /**
     * @param receiver
     */
    public New(AppInterpreter app) {
        super(Label.NEW, app);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {
        
        entity().newInterpreter();
    }
}
