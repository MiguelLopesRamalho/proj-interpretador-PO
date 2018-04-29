package pex.app.main;

import java.io.IOException;

import pex.core.*;

import java.util.*;
import java.io.*;
import pt.utl.ist.po.ui.*;

/**
 * Save to file under current name (if unnamed, query for name).
 */
public class Save extends Command<AppInterpreter> {
    /**
     * @param receiver
     */
    public Save(AppInterpreter app) {
        super(Label.SAVE, app);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() throws InvalidOperation {

        Form f = new Form();
        InputString s = new InputString(f, Message.newSaveAs());
        f.parse(); 
        String fileName = s.value();

        try {
            entity().saveInterpreter(fileName);
        }

        catch(IOException ex) {
            ex.printStackTrace();
        }
    }   
}
