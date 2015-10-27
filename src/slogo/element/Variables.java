package slogo.element;

import java.util.Optional;

import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import slogo.interpreter.EngineController;

public class Variables extends AbstractList {

	private EngineController myEngineController;

	public Variables(GridPane pane, ObservableArrayList list, Console console, EngineController EngineController) {
		super(pane, list, console);
		myEngineController = EngineController;
	}

	@Override
	protected void click() {
		String s = list.getSelectionModel().getSelectedItem();
		String variable = s.substring(0, s.indexOf(' '));
		TextInputDialog input = new TextInputDialog("");
		input.setTitle(slogoResources.getString("vtitle"));
		input.setContentText(slogoResources.getString("vprompt") + variable + ":");
		Optional<String> response = input.showAndWait();
		if (response.isPresent()) {
			// response.get() gives you the inputed string. Make sure its a
			// proper input and change the variable
		}
	}
}
