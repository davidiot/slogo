package slogo.parameters;

import javafx.scene.image.Image;

public class LocalParameters {
	private Image image;
	private String penColor;

	public LocalParameters(int i) {
		image = new Image(getClass().getClassLoader().getResourceAsStream("Images/SlogoTurtle" + i + ".png"));
		
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
