package pex.core;

//import 
import java.util.*;
import java.io.*;
import pex.AppIO;
 
public class Interpreter implements Serializable {

	private Map _programs; 
	private IdMap _idMap;
	private AppIO _appIO;

	public Interpreter(AppIO appIO) { 
		_programs = new Map();
		_idMap = new IdMap();
		_appIO = appIO;
	}

	public Map getProgramMap() { return _programs; }

	public IdMap getIdMap(){
		return _idMap;
	}

	public void addProgram(Program prog) { 
		if(_programs.contains(prog)) {
			_programs.remove(prog);
			_programs.addPair(prog.getName(), prog);
		}
		else {
			_programs.addPair(prog.getName(), prog);
		}
	}

	public boolean contains(String name) {
		return _programs.contains(name);
	}

	public Program getProgram(String name) {
		return _programs.getProgram(name);
	}

	public AppIO getAppIO(){
		return _appIO;
	}
}