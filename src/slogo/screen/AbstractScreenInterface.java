package slogo.screen;

import javafx.scene.Scene;
import javafx.stage.Stage;

public interface AbstractScreenInterface {

	abstract public void run();

	public Scene getScene();

	public AbstractScreen getNextScreen();

	public String getTitle();

	public void makeWindow(Stage stage, AbstractWindowScreen screen);
	
}