package slogo.screen;

import java.util.ResourceBundle;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import slogo.element.Canvas;
import slogo.element.Commands;
import slogo.element.Console;
import slogo.element.History;
import slogo.element.Variables;
import slogo.interpreter.Interpreter;

public class SlogoScreen extends AbstractScreen {

	private String language;
	private Console console;
	private History history;
	private Commands commands;
	private Variables variables;
	private Canvas map;
	private Interpreter parser;
	private ResourceBundle slogoResources;

	public SlogoScreen(String language) {
		this.language = language;
		slogoResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "slogo");
		WIDTH = Integer.parseInt(slogoResources.getString("width"));
		HEIGHT = Integer.parseInt(slogoResources.getString("height"));
		root = new GridPane();
		scene = new Scene(root, WIDTH, HEIGHT);
		try {
			title = slogoResources.getString((language));
		} catch (java.util.MissingResourceException e) {
			title = "SLogo";
		}
		makeScene();
		parser = new Interpreter(this.language, this);
	}

	@Override
	public void run() {
		if (parameters != null && parameters.getBackgroundColor() != null) {
			map.changeColor(parameters.getBackgroundColor());
		}
		if (console.hasInput()) {
			String command = console.getInput();
			parser.interpret(command);
			history.add(command);
		}
	}

	private void makeScene() {
		GridPane title = makeTitle();
		GridPane.setColumnSpan(title, 2);
		root.add(title, 0, 0);
		GridPane mapPane = new GridPane();
		map = new Canvas(mapPane);
		root.add(mapPane, 0, 1);

		GridPane consolePane = new GridPane();
		console = new Console(consolePane);
		GridPane.setColumnSpan(consolePane, 2);

		root.add(consolePane, 0, 2);

		makeLists();
		root.setVgap(Integer.parseInt(slogoResources.getString("VGap")));
		setAlignment(root);
	}

	public GridPane makeTitle() {
		GridPane title = new GridPane();
		Text temp = createText("SLogo", Integer.parseInt(myResources.getString("smallTitle")));
		title.add(temp, 0, 0);
		return title;
	}

	public void makeLists() {
		GridPane listPane = new GridPane();
		GridPane historyPane = new GridPane();
		history = new History(historyPane);
		listPane.add(historyPane, 0, 0);
		GridPane commandPane = new GridPane();
		commands = new Commands(commandPane);
		listPane.add(commandPane, 0, 1);
		GridPane varPane = new GridPane();
		variables = new Variables(varPane);
		listPane.add(varPane, 0, 2);
		listPane.setMaxHeight(Integer.parseInt(slogoResources.getString("mapHeight")));
		listPane.setVgap(Integer.parseInt(slogoResources.getString("VGap")));
		listPane.setAlignment(Pos.BASELINE_LEFT);

		GridPane buttonPane = new GridPane();
		buttonPane.add(makeBackButton(), 0, 0);
		buttonPane.add(makeHelpButton(), 1, 0);
		buttonPane.add(makeSettingsButton(), 2, 0);
		buttonPane.setHgap(Integer.parseInt(slogoResources.getString("HGap")));
		listPane.add(buttonPane, 0, 3);

		root.add(listPane, 1, 1);
	}
}
