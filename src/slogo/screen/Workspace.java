package slogo.screen;

import java.util.ResourceBundle;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import slogo.element.AbstractElement;
import slogo.element.Commands;
import slogo.element.Console;
import slogo.element.Display;
import slogo.element.History;
import slogo.element.ObservableArrayList;
import slogo.element.Variables;
import slogo.interpreter.EngineController;
import slogo.interpreter.InterpreterException;
import slogo.parameters.GlobalParameters;

public class Workspace extends AbstractElement {

	private String language;
	private Console console;
	private History history;
	private Commands commands;
	private Variables variables;
	private Display map;
	private EngineController myEngineController;
	private ResourceBundle slogoResources;
	private ObservableArrayList h;
	private ObservableArrayList c;
	private ObservableArrayList v;
	private int WIDTH;
	private int HEIGHT;
	private GridPane desk;
	private GlobalParameters parameters;

	public Workspace(String language, SlogoScreenInterface screen, GridPane pane, GlobalParameters parameters) {
		super(pane);
		this.language = language;
		slogoResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "slogo");
		WIDTH = Integer.parseInt(slogoResources.getString("width"));
		HEIGHT = Integer.parseInt(slogoResources.getString("height"));
		desk = new GridPane();
		myEngineController = new EngineController(this.language, screen);
		this.parameters = parameters;
		makePane();
	}

	public void makeLists() {
		h = new ObservableArrayList();
		c = new ObservableArrayList();
		v = new ObservableArrayList();
		GridPane listPane = new GridPane();
		GridPane historyPane = new GridPane();
		history = new History(historyPane, h, console);
		listPane.add(historyPane, 0, 0);
		GridPane commandPane = new GridPane();
		commands = new Commands(commandPane, c, console);
		listPane.add(commandPane, 0, 1);
		GridPane varPane = new GridPane();
		variables = new Variables(varPane, v, console);
		listPane.add(varPane, 0, 2);
		listPane.setMaxHeight(Integer.parseInt(slogoResources.getString("mapHeight")));
		listPane.setVgap(Integer.parseInt(slogoResources.getString("VGap")));
		listPane.setAlignment(Pos.BASELINE_LEFT);
		GridPane buttonPane = new GridPane();
		// buttonPane.add(makeBackButton(), 0, 0);
		// buttonPane.add(makeHelpButton(), 1, 0);
		// buttonPane.add(makeSettingsButton(), 2, 0);
		// buttonPane.setHgap(Integer.parseInt(slogoResources.getString("HGap")));
		listPane.add(buttonPane, 0, 3);

		desk.add(listPane, 1, 1);
	}

	@Override
	protected void makePane() {
		GridPane mapPane = new GridPane();
		map = new Display(mapPane);
		desk.add(mapPane, 0, 0);

		GridPane consolePane = new GridPane();
		console = new Console(consolePane);
		GridPane.setColumnSpan(consolePane, 2);

		desk.add(consolePane, 0, 1);

		makeLists();

		desk.setVgap(Integer.parseInt(slogoResources.getString("VGap")));
		pane.getChildren().add(desk);
	}

}
