package slogo.parameters;

import java.util.ResourceBundle;

import javafx.scene.image.Image;

public class LocalParameters {
	private Image image;
	private String penColor;
	protected final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	protected ResourceBundle slogoResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "slogo");

	public LocalParameters(int i) {
		image = new Image(getClass().getClassLoader().getResourceAsStream("Images/SlogoTurtle" + i + ".png"));
		penColor = slogoResources.getString("penColor");
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
