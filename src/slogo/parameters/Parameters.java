package slogo.parameters;

import java.util.HashMap;

import javafx.scene.image.Image;

public class Parameters {
	private HashMap<String, Double> values;
	private String backgroundColor;
	private String penColor;
	private Image image;

	public Parameters() {
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

	public String getPenColor() {
		return penColor;
	}

	public void setPenColor(String penColor) {
		this.penColor = penColor;
	}

	public Image getImage() {
		Image output = image;
		image = null;
		return output;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}
