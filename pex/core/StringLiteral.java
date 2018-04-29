package pex.core;

import java.io.*;


public class StringLiteral extends Literal implements Serializable {

	private String _value;

	public StringLiteral(String value) {
		_value = value;
	}

	public String getAsText() { return "\"" + _value + "\""; }

	public String getValue() { return _value; }

}