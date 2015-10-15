package slogo.element;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import slogo.character.*;

public class Display extends AbstractElement {

	private Rectangle map;
	private Canvas test;
	private GraphicsContext gc;
	private Pane display;
	private Pane characterDisplay;
	private List<MainCharacter> characters;

	public Display(GridPane pane) {
		super(pane);
	}

	@Override
	protected void makePane() {
		display = new StackPane();
		characterDisplay = new Pane();
		MainCharacter mc = new MainCharacter(100,100, characterDisplay);
		characters = new ArrayList<MainCharacter>();
		characters.add(mc);
		map = new Rectangle(Integer.parseInt(slogoResources.getString("mapWidth")),
				Integer.parseInt(slogoResources.getString("mapHeight")), Color.WHITE);
		test = new Canvas(
				Integer.parseInt(slogoResources.getString("mapWidth")),
				Integer.parseInt(slogoResources.getString("mapHeight")));
		gc = test.getGraphicsContext2D();
		//gc.setFill(Color.WHITE);
		//gc.fillRect(0, 0, test.getWidth(), test.getHeight());		
		characterDisplay.getChildren().add(test);
		characterDisplay.getChildren().add(mc.getImageView());
		display.getChildren().addAll(map, characterDisplay);
		this.pane.getChildren().add(display);
		mc.move(100);
		mc.rotateCharacter(135);
		mc.move(100);
	}

	public void changeColor(String input) {
		map.setFill(Paint.valueOf(input));
	}
	
	public void changePenColor(String input){
		for(MainCharacter mc: characters){
			mc.changePenColor(input);
		}
	}
	
	public void addCharacter(MainCharacter mc){
		characters.add(mc);
		display.getChildren().add(mc.getImageView());
	}
	
	// temporary method for testing
	public MainCharacter getMainCharacter(){
		return characters.get(0);
	}
}
