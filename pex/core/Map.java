package pex.core;

//imports 
import java.util.*;
import java.io.*;

public class Map implements Serializable {
	
	private HashMap<String, Program> hmap; 

	public Map() {
		hmap = new HashMap<String, Program>();
	}

	public void addPair(String name, Program prog){
		hmap.put(name, prog);
	}

	public Program getProgram(String progName){
		return hmap.get(progName);
	}

	public boolean contains(Program prog){
		return hmap.containsValue(prog);
	}

	public boolean contains(String name) {
		return hmap.containsKey(name);
	}

	public void remove(Program prog){
		hmap.remove(prog.getName());
	}
}