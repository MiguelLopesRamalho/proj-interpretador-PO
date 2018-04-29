package pex.app.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import pex.core.*;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Open existing interpreter.
 */
public class Open extends Command<AppInterpreter> {
    /**
     * @param receiver
     */
    public Open(AppInterpreter app) {
        super(Label.OPEN, app);
    }

    /** @see pt.tecnico.po.ui.Command#execute() */
    @Override
    public final void execute() throws InvalidOperation {

        Form f = new Form();
        InputString s = new InputString(f, Message.openFile());
        f.parse(); 
        String fileName = s.value();  
    
        try {
            entity().loadInterpreter(fileName);
        }

        catch(IOException ex) {
            throw new InvalidOperation(/*Message.fileNotFound(fileName)*/);
        }

        catch(ClassNotFoundException ex) {
            throw new InvalidOperation("Erro a carregar ficheiro");
        }
    }
}
