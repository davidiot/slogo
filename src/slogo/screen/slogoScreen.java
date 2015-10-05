package slogo.screen;

import java.util.ResourceBundle;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class slogoScreen extends AbstractScreen {

	private String language;

	public slogoScreen(String language) {
		this.language = language;
		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "slogo");
		WIDTH = Integer.parseInt(myResources.getString("width"));
		HEIGHT = Integer.parseInt(myResources.getString("height"));
		root = new GridPane();
		scene = new Scene(root, WIDTH, HEIGHT);
		root.add(makeBackButton(), 0, 0);
		setAlignment(root);
		try {
			title = myResources.getString((language));
		} catch (java.util.MissingResourceException e) {
			title = "SLogo";
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}
