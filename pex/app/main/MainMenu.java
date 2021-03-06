package pex.app.main;

import pex.core.*;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;

/**
 * Menu builder.
 * Represents the main menu of this application. This is the first menu
 * shown to the users.
*/
public class MainMenu extends Menu {

    /**
     * @param receiver
     */
    public MainMenu(AppInterpreter app) { //receives 
        super(Label.TITLE,
              new Command<?>[] { //
                  new New(app), //
                  new Open(app), //
                  new Save(app), //
                  new NewProgram(app), //
                  new ReadProgram(app), //
                  new WriteProgram(app), //
                  new EditProgram(app), //
                });
    }
}
