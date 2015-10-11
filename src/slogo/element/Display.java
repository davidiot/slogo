package slogo.element;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import slogo.character.*;

public class Display extends AbstractElement {

	private Rectangle map;
	private Canvas test;
	private GraphicsContext gc;

	public Display(GridPane pane) {
		super(pane);
	}

	@Override
	protected void makePane() {
		MainCharacter turtle = new MainCharacter(100,100);
		map = new Rectangle(Integer.parseInt(slogoResources.getString("mapWidth")),
				Integer.parseInt(slogoResources.getString("mapHeight")), Color.WHITE);
		pane.add(map, 0, 0);
		pane.getChildren().add(turtle.getImageView());
		/**test = new Canvas(
				Integer.parseInt(slogoResources.getString("mapWidth")),
				Integer.parseInt(slogoResources.getString("mapHeight")));
		gc = test.getGraphicsContext2D();
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, test.getWidth(), test.getHeight());
		gc.drawImage(turtle.getImage(), 100, 100);
		gc.r
		this.pane.getChildren().add(test);
		//this.pane.getChildren().add(turtle.getImageView());
		//this.pane.getChildren().add(turtle.getImageView());**/
	}

	public void changeColor(String input) {
		gc.setFill(Paint.valueOf(input));
		gc.fillRect(0, 0, test.getWidth(), test.getHeight());
	}
}
