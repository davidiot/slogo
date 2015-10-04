package slogo.screen;

import java.util.ResourceBundle;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public abstract class AbstractScreen {
	protected GridPane root;
	protected Scene scene;
	protected int WIDTH;
	protected int HEIGHT;
	protected String titleName = "";
	protected AbstractScreen nextScreen = null;
	protected final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	protected ResourceBundle myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "screen");

	abstract public void run();

	public Scene getScene() {
		return scene;
	}

	public AbstractScreen getNextScreen() {
		return nextScreen;
	}

	protected void setAlignment(GridPane r) {
		r.setAlignment(Pos.CENTER);
		for (Node n : r.getChildren()) {
			if (n instanceof GridPane) {
				setAlignment((GridPane) n);
			}
		}
	}
}
