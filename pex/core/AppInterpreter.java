package pex.core;

import java.util.*;
import java.io.*;
import pt.utl.ist.po.ui.*;
import pex.app.main.Message;
import pex.parser.*;
import pex.AppIO;

public class AppInterpreter implements Serializable {

	private Interpreter _interpreter;
    private NewParser _parser;
    private AppIO _appIO;

    public AppInterpreter() {
        _interpreter = new Interpreter(_appIO);
        _parser = new NewParser(_interpreter);
    }

	public void newInterpreter() {
		_interpreter = new Interpreter(_appIO);
	}

    public Interpreter getInterpreter() { return _interpreter; }

    public NewParser getParser() { return _parser; }

	public Interpreter loadInterpreter(String fileName) throws IOException, FileNotFoundException, ClassNotFoundException {
		ObjectInputStream fileToOpen = new ObjectInputStream(new FileInputStream(fileName));
		Interpreter _interpreter = (Interpreter) fileToOpen.readObject();
		fileToOpen.close();
		return _interpreter;
	}

	public void saveInterpreter(String fileName) throws IOException {
		FileOutputStream file = new FileOutputStream(fileName);
		ObjectOutputStream output = new ObjectOutputStream(file);
		output.writeObject(_interpreter);
		output.close();
	}

    public void readProgram(String fileName) throws IOException, ClassNotFoundException, 
                                                        BadSourceException, BadNumberException,
                                                            InvalidExpressionException, MissingClosingParenthesisException, 
                                                                UnknownOperationException, EndOfInputException {
        
        
        Program newProg2 = _parser.parseFile(fileName, fileName);
        _interpreter.addProgram(newProg2);

    }

    public void writeProgram(String fileName, String progName) throws IOException, FileNotFoundException, ClassNotFoundException {
    	PrintWriter writer = new PrintWriter(fileName, "UTF-8");
        for(Expression e: _interpreter.getProgram(progName).getList()) {
            writer.println(e.getAsText() + "\n");
        }
        writer.close();
    }
}