package pex.app;

import pex.core.*;
import pex.parser.*;

import pex.AppIO;
import pex.parser.ParserException;
import pex.app.main.MainMenu;

import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.Display;

/**
 * This is a sample client for the expression evaluator.
 * It uses a text-based user interface.
 */
public class App implements AppIO {
    // Add fileds here if needed

    public App() {
	// add core here if needed
    }

    /**
     * Writes a string to be presented to the user.
     *
     * @param str the string to write
     **/
    public void println(String str) {
        // add code here 
        Display d = new Display();
        d.add(str);
        d.display();
    }

    /**
     * Reads a string inputed by the user.
     *
     * @return the string written by the user.
     **/
    public String readString() {
        // add code here
        Form f = new Form();
        InputString s = new InputString(f, "Introduza a string: ");
        f.parse();
        return s.value();
    }

    /**
     * Reads an integer inputed by the user.
     *
     * @return the number written by the user.
     **/
    public int readInteger() {
        // add code here
        Form f = new Form();
        InputInteger i = new InputInteger(f, "Introduza o inteiro: ");
        f.parse();
        return i.value();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        AppInterpreter app = new AppInterpreter();
        NewParser newParser = new NewParser(app.getInterpreter());
        Program importProg = new Program("import", app.getInterpreter());
        
        String datafile = System.getProperty("import"); //$NON-NLS-1$
        if (datafile != null) {
            try {
                importProg = newParser.parseFile(datafile, importProg.getName());
                app.getInterpreter().addProgram(importProg);    


            } catch (ParserException e) {
                // no behavior described: just present the problem
                e.printStackTrace();
            }
        }
        
        MainMenu menu = new MainMenu(app);
        menu.open();
    }
}
