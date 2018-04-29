package pex.core;

//imports 
import java.util.*;
import java.io.*;

public class IdMap implements Serializable  {
	
	private HashMap<String, Literal> _idMap; 

	public IdMap() {
		_idMap = new HashMap<String, Literal>();
	}

	public HashMap getMap(){
		return _idMap;
	}

	public void addPair(String name, Literal lit){
		_idMap.put(name, lit);
	}

	public Literal getValue(String name){
		return _idMap.get(name);
	}

	public boolean contains(String name){
		return _idMap.containsValue(name);
	}
}
