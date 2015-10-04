package slogo.managers;

import slogo.screen.AbstractScreen;
import slogo.screen.StartScreen;
import javafx.stage.Stage;

public class RootManager {

	private Stage stage;
	private AbstractScreen currentScreen;

	public void init(Stage s) {
		stage = s;
		currentScreen = new StartScreen();
		stage.setScene(currentScreen.getScene());
		stage.show();
		stage.setResizable(false);
	}

	public void run() {
		currentScreen.run();
		if (currentScreen.getNextScreen() != null) {
			currentScreen = currentScreen.getNextScreen();
			stage.setScene(currentScreen.getScene());
			stage.show();
		}
	}

}
