package slogo.element;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
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

	public Display(GridPane pane) {
		super(pane);
	}

	@Override
	protected void makePane() {
		display = new Pane();
		MainCharacter mc = new MainCharacter(100,100);
		test = new Canvas(
				Integer.parseInt(slogoResources.getString("mapWidth")),
				Integer.parseInt(slogoResources.getString("mapHeight")));
		gc = test.getGraphicsContext2D();
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, test.getWidth(), test.getHeight());		
		display.getChildren().add(test);
		display.getChildren().add(mc.getImageView());
		this.pane.getChildren().add(display);
	}

	public void changeColor(String input) {
		gc.setFill(Paint.valueOf(input));
		gc.fillRect(0, 0, test.getWidth(), test.getHeight());
	}
	
	public void addCharacter(MainCharacter mc){
		display.getChildren().add(mc.getImageView());
	}
}
