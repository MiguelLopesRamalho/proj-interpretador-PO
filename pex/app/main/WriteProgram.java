package pex.app.main;

import java.io.IOException;

import pex.core.*;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Write (save) program to file.
 */
public class WriteProgram extends Command<AppInterpreter> {
    /**
     * @param receiver
     */
    public WriteProgram(AppInterpreter app) {
        super(Label.WRITE_PROGRAM, app);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() throws InvalidOperation {

        Display d = new Display();
        Form f = new Form();
        InputString s = new InputString(f, Message.requestProgramId());
        f.parse(); 
        String progName = s.value(); 

        Form f2 = new Form();
        InputString s2 = new InputString(f2, Message.programFileName());
        f2.parse(); 
        String fileName = s2.value();       
        
        try {
            if(entity().getInterpreter().contains(progName))
                entity().writeProgram(fileName, progName);
            else
                d.add(Message.noSuchProgram(progName));
                d.display();
        }

        catch (IOException ex) {
            throw new InvalidOperation("Erro a escrever programa");
        }

        catch (ClassNotFoundException ex) {
            throw new InvalidOperation("Erro a escrever programa (classe)");
        }
    }
}