package slogo.element;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import slogo.character.CharacterInterface;
import slogo.character.MainCharacter;
import slogo.parameters.GlobalParameters;
import slogo.screen.AbstractScreen;

public class Display extends AbstractElement {

	private Rectangle map;
	private Rectangle background;
	private Canvas test;
	private GraphicsContext gc;
	private Pane display;
	private Pane temp;
	private Pane characterDisplay;
	private List<MainCharacter> characters;
	private HashSet<Integer> activeIndices;
	private int counter = 0;

	public Display(GridPane pane) {
		super(pane);
		makePane();
	}

	@Override
	protected void makePane() {
		display = new StackPane();
		characterDisplay = new Pane();
		characterDisplay.setMouseTransparent(true);
		MainCharacter mc = new MainCharacter(characterDisplay, parameters, counter);
		characters = new ArrayList<MainCharacter>();
		characters.add(mc);
		activeIndices = new HashSet<Integer>();
		activeIndices.add(0);
		background = new Rectangle(
				Double.parseDouble(slogoResources.getString("mapWidth"))
						+ 2 * Double.parseDouble(slogoResources.getString("characterCenterX")),
				Double.parseDouble(slogoResources.getString("mapHeight"))
						+ 2 * Double.parseDouble(slogoResources.getString("characterCenterY")),
				Color.TRANSPARENT);
		map = new Rectangle(Integer.parseInt(slogoResources.getString("mapWidth")),
				Integer.parseInt(slogoResources.getString("mapHeight")), Color.WHITE);
		map.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				Point2D locationInScene = new Point2D(
						e.getSceneX() - Double.parseDouble(slogoResources.getString("characterCenterX")),
						e.getSceneY() - Double.parseDouble(slogoResources.getString("characterCenterY")));
				Point2D locationInParent = characterDisplay.sceneToLocal(locationInScene);
				addCharacter(locationInParent.getX(), locationInParent.getY());
			}
		});
		test = new Canvas(Integer.parseInt(slogoResources.getString("mapWidth")),
				Integer.parseInt(slogoResources.getString("mapHeight")));
		gc = test.getGraphicsContext2D();
		characterDisplay.getChildren().add(test);
		display.getChildren().addAll(background, map, characterDisplay);
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

	public void addCharacter(double x, double y) {
		counter++;
		MainCharacter mc = new MainCharacter(characterDisplay, parameters, counter, x, y);
		activeIndices.add(counter);
		characters.add(mc);
	}

	public CharacterInterface getCharacter() {
		return characters.get(counter);
	}

	public void updateCharacters() {
		for (MainCharacter mc : characters) {
			mc.update();
		}
	}

	// public void changePenWidth(Double input) {
	// for (MainCharacter mc : characters) {
	// mc.changePenWidth(input);
	// }
	// }
	//
	// public void changeSpeed(Double value) {
	// for (MainCharacter mc : characters) {
	// mc.changeSpeed(value);
	// }
	// }
	//
	// public void changeDashLevel(Double value) {
	// for (MainCharacter mc : characters) {
	// mc.changeDashLevel(value);
	// }
	// }

	public double clear() {
		double distance = 0;
		for (MainCharacter mc : characters) {
			distance += mc.goHome();
		}
		makePane();
		return distance;
	}
}
