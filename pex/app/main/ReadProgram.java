package pex.app.main;

import pex.core.*;
import pex.parser.*;

import pt.utl.ist.po.ui.*;
import java.io.IOException;

/**
 * Read existing program.
 */
public class ReadProgram extends Command<AppInterpreter> {
    /**
     * @param receiver
     */
    public ReadProgram(AppInterpreter app) {
        super(Label.READ_PROGRAM, app);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() throws InvalidOperation {

        Form f = new Form();
        InputString s = new InputString(f, Message.programFileName());
        f.parse();
        String fileName = s.value();
      
        try { 
            entity().readProgram(fileName);
        }

        catch(IOException ex) {
            throw new InvalidOperation("Erro a ler programa");
        }

        catch(ClassNotFoundException ex) {
            throw new InvalidOperation("Erro a ler programa");
        }

        catch(ParserException pe) {
            //throw new InvalidOperation();
        }
    }
}