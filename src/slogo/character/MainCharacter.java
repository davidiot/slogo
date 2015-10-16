package slogo.character;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.ResourceBundle;

public class MainCharacter {
	protected final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	protected ResourceBundle slogoResources = ResourceBundle
			.getBundle(DEFAULT_RESOURCE_PACKAGE + "slogo");
	private static final double XADJUST = 18;
	private static final double YADJUST = 19;
	private double xCenter = Integer.parseInt(slogoResources.getString("mapWidth"))/2;
	private double yCenter = Integer.parseInt(slogoResources.getString("mapHeight"))/2;
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
		penColor = Color.valueOf(input);
	}
	
	public void returnHome(){
		preX = curX;
		preY = curY;
		curX = xCenter;
		curY = yCenter;
		imageView.setX(curX);
		imageView.setY(curY);
		refreshImage();
	}
	
	public double getDistanceMoved(){
		return Math.sqrt(Math.pow(curX - preX, 2) + (Math.pow(curY - preY, 2)));
	}
	
	
}
