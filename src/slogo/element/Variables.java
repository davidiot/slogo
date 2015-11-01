package slogo.element;

import java.util.Optional;

import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import slogo.interpreter.EngineController;

public class Variables extends AbstractList {

	public Variables(GridPane pane, ObservableArrayList list, Console console, EngineController EngineController) {
		super(pane, list, console, EngineController);
	}

	@Override
	protected void click() {
		String s = list.getSelectionModel().getSelectedItem();
		if (s != null) {
			String variable = s.substring(0, s.indexOf(' '));
			TextInputDialog input = new TextInputDialog("");
			input.setTitle(slogoResources.getString("vtitle"));
			input.setContentText(slogoResources.getString("vprompt") + variable + ":");
			Optional<String> response = input.showAndWait();
			if (response.isPresent()) {
				myEngineController.getVariableLibrary().addVariable(":" + variable, Double.parseDouble(response.get()));
				myEngineController.updateVariablesListInGUI();
			}
		}
	}
}
