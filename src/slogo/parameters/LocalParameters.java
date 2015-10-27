package slogo.parameters;

import java.util.ResourceBundle;

import javafx.scene.image.Image;

public class LocalParameters {
	private Image image;
	private String penColor;
	protected final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	protected ResourceBundle slogoResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "slogo");
	private int index;
	private boolean penDown;
	private boolean hidden;

	public LocalParameters(int i) {
		image = new Image(getClass().getClassLoader().getResourceAsStream("Images/SlogoTurtle" + i % 10 + ".png"));
		penColor = slogoResources.getString("penColor");
		index = i;
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

	public int getIndex() {
		return index;
	}

	public boolean isPenDown() {
		return penDown;
	}

	public void setPenDown(boolean penDown) {
		this.penDown = penDown;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
}
