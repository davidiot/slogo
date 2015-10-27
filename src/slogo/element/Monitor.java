package slogo.element;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import slogo.character.MainCharacter;
import slogo.parameters.LocalParameters;

public class Monitor extends AbstractElement {
	private String title;
	private Text text;
	private boolean open;
	private ListView<MainCharacter> list;

	public Monitor(GridPane pane) {
		super(pane);
		makePane();
	}

	@Override
	protected void makePane() {
		title = slogoResources.getString(this.getClass().getName());
		open = true;
		text = new Text(title);
		text.setFont(font);
		pane.add(text, 0, 0);
		list = new ListView<MainCharacter>(parameters.getCharacters());
		pane.add(list, 0, 1);
	}

	private void click() {

	}
}
