package slogo.parameters;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class GlobalParameters {
	private HashMap<String, Double> values;
	private Color backgroundColor;
	private String backgroundColorName;
	protected final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	protected ResourceBundle slogoResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "slogo");

	public GlobalParameters() {
		values = new HashMap<String, Double>();
		try {
			Scanner s = new Scanner(new File("src/resources/settings.txt"));
			while (s.hasNext()) {
				String next = s.nextLine();
				if (next.equals("0")) {
					break;
				}
				String[] vals = s.nextLine().split(" ");
				this.setValue(next, Double.parseDouble(vals[0]));
			}
		} catch (

		FileNotFoundException e)

		{
			e.printStackTrace();
		}
		backgroundColor = Color.valueOf(slogoResources.getString("mapColor"));
	}

	public Double getValue(String input) {
		return values.get(input);
	}

	public void setValue(String input, Double value) {
		values.put(input, value);
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = Color.valueOf(backgroundColor);
		backgroundColorName = backgroundColor;
	}

	public void setBackgroundColorHex(String backgroundColor) {
		this.backgroundColor = Color.web(backgroundColor);
		backgroundColorName = null;
	}

	public String getBackgroundColorName() {
		return backgroundColorName;
	}

	public HashMap<String, Double> getValueMap() {
		return values;
	}
}
