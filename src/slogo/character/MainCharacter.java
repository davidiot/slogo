package slogo.character;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class MainCharacter {
	private boolean penDown = true;
	private boolean hidden = false;
	private double preX;
	private double preY;
	private double curX;
	private double curY;
	private double direction;
	private Image image;
	private ImageView imageView;

	public MainCharacter(int x, int y) {
		curX = x;
		preX = 0;
		curY = y;
		preY = 0;
		direction = 0;
		if(!hidden){
			image = new Image(getClass().getClassLoader().getResourceAsStream("Images/SlogoTurtle.png"));
		}
		else{
			image = new Image("Images/blank.png");
		}
		imageView = new ImageView();
		imageView.setImage(image);
		imageView.setX(curX);
		imageView.setY(curY);
	}

	public ImageView getImageView() {
		return imageView;  
	}
	
	public Image getImage(){
		return image;
	}
	
	public void move(int distance){
		preX = curX;
		preY = curY;
		curX += distance * Math.sin(90.0 - direction);
		curY += distance * Math.cos(90.0 - direction);
	}
	
	public void showCharacter(){
		hidden = false;
	}
	
	public void hideCharacter(){
		hidden = true;
	}
	
	public void rotateCharacter(int degree){
		imageView.setRotate(degree);
	}
}
