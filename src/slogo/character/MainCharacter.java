package slogo.character;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class MainCharacter {
	private static final double XADJUST = 18;
	private static final double YADJUST = 19;
	private boolean penDown = true;
	private boolean hidden = false;
	private double preX;
	private double preY;
	private double curX;
	private double curY;
	private double direction;
	private Image image;
	private ImageView imageView;
	private Color penColor;
	private Pane myPane;

	public MainCharacter(int x, int y, Pane pane) {
		myPane = pane;
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
		penColor = Color.BLACK;
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
		curX += distance * Math.cos(Math.toRadians(90.0-direction));
		curY -= distance * Math.sin(Math.toRadians(90.0-direction));
		imageView.setX(curX);
		imageView.setY(curY);
		if(penDown){
			Line line = new Line(preX+XADJUST, preY+YADJUST, curX+XADJUST, curY+YADJUST);
			System.out.println(penColor);
			line.setStroke(penColor);
			myPane.getChildren().add(line);
		}
		refreshImage();
	}
	
	public void showCharacter(){
		hidden = false;
	}
	
	public void hideCharacter(){
		hidden = true;
	}
	
	public void rotateCharacter(int degree){
		direction += degree;
		imageView.setRotate(degree);
		refreshImage();
	}
	
	public void refreshImage(){
		myPane.getChildren().remove(imageView);
		myPane.getChildren().add(imageView);
	}
	
	public void changePenColor(String input){
		System.out.print("Changing pen color to: ");
		System.out.println(penColor);
		penColor = Color.valueOf(input);
	}
}
