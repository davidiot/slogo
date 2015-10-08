package slogo.element;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

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
		test = new Canvas(
				Integer.parseInt(slogoResources.getString("mapWidth")),
				Integer.parseInt(slogoResources.getString("mapHeight")));
		gc = test.getGraphicsContext2D();
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, test.getWidth(), test.getHeight());
		pane.getChildren().add(test);
		pane.getChildren().add(turtle.getImageView());
	}

	public void changeColor(String input) {
		gc.setFill(Paint.valueOf(input));
		gc.fillRect(0, 0, test.getWidth(), test.getHeight());
	}
}
