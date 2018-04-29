package pex.app.main;

import pex.core.*;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;

/**
 * Create new program.
 */
public class NewProgram extends Command<AppInterpreter> {

    /**
     * @param receiver
     */
    public NewProgram(AppInterpreter app) {
        super(Label.NEW_PROGRAM, app);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {

        Form f = new Form();
        InputString s = new InputString(f, Message.requestProgramId());
        f.parse(); 
        String progName = s.value();
        Program prog = new Program(progName, entity().getInterpreter());
        entity().getInterpreter().addProgram(prog); 
    }
}
