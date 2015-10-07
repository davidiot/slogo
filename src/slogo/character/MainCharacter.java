package slogo.character;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class MainCharacter {
	private boolean penDown;
	private int preX;
	private int preY;
	private int curX;
	private int curY;
	private int direction;
	private ImageView image;

	public MainCharacter(int x, int y) {
		curX = x;
		preX = 0;
		curY = y;
		preY = 0;
		direction = 0;
		penDown = true;
		Image im = new Image(getClass().getClassLoader().getResourceAsStream("Images/SlogoTurtle.png"));
		image = new ImageView(im);
		image.setX(curX);
		image.setY(curY);
	}

	public ImageView getImageView() {
		return image;
	}
	
}
