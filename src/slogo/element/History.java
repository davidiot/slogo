package slogo.element;

import javafx.scene.layout.GridPane;
import slogo.interpreter.EngineController;

public class History extends AbstractList {

	public History(GridPane pane, ObservableArrayList list, Console console, EngineController myEngineController) {
		super(pane, list, console, myEngineController);
		// TODO Auto-generated constructor stub
	}

	protected void click() {
		console.overwrite(list.getSelectionModel().getSelectedItem());
	}
}
