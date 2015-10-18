package slogo.element;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import java.awt.color.*;
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
		MainCharacter mc = new MainCharacter(characterDisplay);
		characters = new ArrayList<MainCharacter>();
		characters.add(mc);
		map = new Rectangle(Integer.parseInt(slogoResources.getString("mapWidth")),
				Integer.parseInt(slogoResources.getString("mapHeight")), Color.WHITE);
		test = new Canvas(Integer.parseInt(slogoResources.getString("mapWidth")),
				Integer.parseInt(slogoResources.getString("mapHeight")));
		gc = test.getGraphicsContext2D();
		characterDisplay.getChildren().add(test);
		characterDisplay.getChildren().add(mc.getImageView());
		display.getChildren().addAll(map, characterDisplay);
		this.pane.getChildren().add(display);
	}

	public void changeColor(String input) {
		map.setFill(Paint.valueOf(input));
	}

	public void changePenColor(String input) {
		for (MainCharacter mc : characters) {
			mc.changePenColor(input);
		}
	}

	public void changePenWidth(Double input) {
		for (MainCharacter mc : characters) {
			mc.changePenWidth(input);
		}
	}

	public void addCharacter(MainCharacter mc) {
		characters.add(mc);
		display.getChildren().add(mc.getImageView());
	}

	public MainCharacter getCharacter(int input) {
		return characters.get(input);
	}

	public void updateCharacters() {
		for (MainCharacter mc : characters) {
			mc.update();
		}
	}

	public void changeSpeed(Double value) {
		for (MainCharacter mc : characters) {
			mc.changeSpeed(value);
		}
	}

	public double clear() {
		double distance = 0;
		for (MainCharacter mc : characters) {
			distance += mc.goHome();
		}
		makePane();
		return distance;
	}

	public void setImage(Image image) {
		for (MainCharacter mc : characters) {
			mc.setImage(image);
		}
	}
}
