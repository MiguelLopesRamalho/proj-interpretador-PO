package pex.core;

import java.io.*;

public class IntegerLiteral extends Literal implements Serializable {

	private int _value;

	public IntegerLiteral(int value) {
		_value = value;
	}

	public String getAsText() { return Integer.toString(_value); }

	public int getValue() { return _value; }
}