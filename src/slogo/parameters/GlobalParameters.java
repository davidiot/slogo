package slogo.parameters;

import java.util.HashMap;

import javafx.scene.image.Image;

public class GlobalParameters {
	private HashMap<String, Double> values;
	private String backgroundColor;

	public GlobalParameters() {
		values = new HashMap<String, Double>();
	}

	public Double getValue(String input) {
		return values.get(input);
	}

	public void setValue(String input, Double value) {
		values.put(input, value);
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

}
