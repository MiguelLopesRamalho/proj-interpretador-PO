package pex.app.main;

import pex.core.*;

import pex.app.evaluator.EvaluatorMenu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;

import pex.app.main.Message;
/**
 * Open menu for managing programs.
 */
public class EditProgram extends Command<AppInterpreter> {

    /**
     * @param receiver
     */
    public EditProgram(AppInterpreter app) {
        super(Label.MANAGE_PROGRAM, app);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {

        Form f = new Form();
        InputString s = new InputString(f, Message.requestProgramId());
        f.parse(); 
        String progName = s.value();

        if(entity().getInterpreter().contains(progName)) {
            EvaluatorMenu menu = new EvaluatorMenu(entity().getInterpreter().getProgramMap().getProgram(progName));
            menu.open();
        }
        else {
            Display d = new Display();
            d.add(Message.noSuchProgram(progName));
            d.display(); 
        }
    }
}
