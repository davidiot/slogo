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
	private Image image;
	private ImageView imageView;

	public MainCharacter(int x, int y) {
		curX = x;
		preX = 0;
		curY = y;
		preY = 0;
		direction = 0;
		penDown = true;
		image = new Image(getClass().getClassLoader().getResourceAsStream("Images/SlogoTurtle.png"));
		imageView = new ImageView();
		imageView.setImage(image);
		imageView.setLayoutX(curX);
		imageView.setLayoutY(curY);
	}

	public ImageView getImageView() {
		return imageView;
	}
	
	public Image getImage(){
		return image;
	}
	
}
