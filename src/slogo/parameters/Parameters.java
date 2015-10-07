package slogo.parameters;

import java.util.HashMap;

public class Parameters {
	private HashMap<String, Double> values;
	private HashMap<String, Boolean> bools;

	public Parameters() {
		values = new HashMap<String, Double>();
		bools = new HashMap<String, Boolean>();
	}

	public Double getValue(String input) {
		return values.get(input);
	}

	public void setValue(String input, Double value) {
		values.put(input, value);
	}

	public boolean getBoolean(String input) {
		return bools.get(input);
	}

	public void setBoolean(String input, boolean bool) {
		bools.put(input, bool);
	}

}
