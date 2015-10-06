package slogo.screen;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public abstract class AbstractWindowScreen extends AbstractScreen {
	public AbstractWindowScreen() {
		WIDTH = Integer.parseInt(myResources.getString("windowWidth"));
		HEIGHT = Integer.parseInt(myResources.getString("windowHeight"));
		root = new GridPane();
		scene = new Scene(root, WIDTH, HEIGHT);
		makeScene();
		setAlignment(root);
		root.setVgap(Integer.parseInt(myResources.getString("vgap")));
		this.title = myResources.getString(this.getClass().getName());
	}

	protected abstract void makeScene();

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
