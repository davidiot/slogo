package slogo.character;

import javafx.scene.paint.Color;
import slogo.parameters.GlobalParameters;
import slogo.parameters.LocalParameters;

public class Movement {
	private String type;
	private double[] value;
	private boolean currentPenDown;
	private double currentPenWidth;
	private Color currentPenColor;

	public Movement(String type, double[] value, LocalParameters settings, GlobalParameters parameters) {
		this.type = type;
		this.value = value;
		currentPenDown = settings.isPenDown();
		currentPenColor = settings.getPenColor();
		currentPenWidth = parameters.getValue("Line Thickness");
	}

	public String getType() {
		return type;
	}

	public double[] getValue() {
		return value;
	}

	public boolean isCurrentPenDown() {
		return currentPenDown;
	}

	public Double getCurrentPenWidth() {
		return currentPenWidth;
	}

	public Color getCurrentPenColor() {
		return currentPenColor;
	}
}