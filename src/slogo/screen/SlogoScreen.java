package slogo.screen;

import java.util.ResourceBundle;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import slogo.element.Console;

public class SlogoScreen extends AbstractScreen {

	private String language;
	private Console console;

	public SlogoScreen(String language) {
		this.language = language;
		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "slogo");
		WIDTH = Integer.parseInt(myResources.getString("width"));
		HEIGHT = Integer.parseInt(myResources.getString("height"));
		root = new GridPane();
		scene = new Scene(root, WIDTH, HEIGHT);
		try {
			title = myResources.getString((language));
		} catch (java.util.MissingResourceException e) {
			title = "SLogo";
		}
		makeScene();
	}

	@Override
	public void run() {
		if (console.hasInput()){
			String command = console.getInput();
			System.out.println(command);
		}
	}

	private void makeScene() {
		root.add(makeBackButton(), 0, 0);
		GridPane consolePane = new GridPane();
		root.add(consolePane, 0, 1);
		console = new Console(consolePane);
		setAlignment(root);
	}
}
