package slogo.element;

import java.util.Observable;
import java.util.Observer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import slogo.interpreter.EngineController;

public abstract class AbstractList extends AbstractElement implements Observer {
	protected String title;
	protected Text text;
	protected boolean open;
	protected ListView<String> list;
	protected ObservableList<String> data;
	protected Console console;
	protected EngineController myEngineController;

	public AbstractList(GridPane pane, ObservableArrayList list, Console console, EngineController myEngineController) {
		super(pane);
		makePane();
		list.addObserver(this);
		this.console = console;
		this.myEngineController = myEngineController;
	}

	@Override
	protected void makePane() {
		title = slogoResources.getString(this.getClass().getName());
		open = true;
		text = new Text(title);
		text.setFont(font);
		text.setOnMouseClicked(e -> toggle());
		pane.add(text, 0, 0);
		data = FXCollections.observableArrayList();
		list = new ListView<String>(data);
		list.setOnMouseClicked(e -> click());
		pane.add(list, 0, 1);
		toggle();
	}

	@Override
	public void update(Observable o, Object arg) {
		data.add((String) arg);
		if (!open) {
			toggle();
		}
	}

	private void toggle() {
		if (open) {
			text.setText(">" + title);
			list.setItems(null);
			list.setMaxHeight(0);
		} else {
			text.setText("*" + title);
			list.setItems(data);
			list.setMaxHeight(Double.MAX_VALUE);
		}
		open = !open;
	}

	protected abstract void click();

	public void add(String s) {
		data.add(s);
		if (!open) {
			toggle();
		}
	}

	public void clear() {
		data.clear();
		super.pane = null;
		super.pane = new GridPane();
	}
}