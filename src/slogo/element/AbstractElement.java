package slogo.element;

import java.util.ResourceBundle;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public abstract class AbstractElement {
	protected GridPane pane;
	protected final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	protected ResourceBundle slogoResources = ResourceBundle
			.getBundle(DEFAULT_RESOURCE_PACKAGE + "slogo");
	protected Font font = Font.loadFont(getClass().getClassLoader()
			.getResourceAsStream("unispace.ttf"), Integer
			.parseInt(slogoResources.getString("fontsize")));

	public AbstractElement(GridPane pane) {
		this.pane = pane;
		makePane();
	}

	protected abstract void makePane();

}
