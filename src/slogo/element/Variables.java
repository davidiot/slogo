package slogo.element;

import java.util.Optional;

import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;

public class Variables extends AbstractList {

	public Variables(GridPane pane, ObservableArrayList list, Console console) {
		super(pane, list, console);
		// TODO Auto-generated constructor stub
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
