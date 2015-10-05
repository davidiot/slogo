package slogo.screen;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class StartScreen extends AbstractScreen {
	private ComboBox<String> loader;
	private Button goButton;
	private Button helpButton;
	private Button settingsButton;

	public StartScreen() {
		WIDTH = Integer.parseInt(myResources.getString("width"));
		HEIGHT = Integer.parseInt(myResources.getString("height"));
		root = new GridPane();
		scene = new Scene(root, WIDTH, HEIGHT);
		root.add(initTitle(), 0, 0);
		root.add(initLoader(), 0, 1);
		root.add(initButtons(), 0, 2);
		setAlignment(root);
		root.setVgap(Integer.parseInt(myResources.getString("vgap")));
	}

	private GridPane initTitle() {
		GridPane title = new GridPane();
		Text temp = createText("SLogo", Integer.parseInt(myResources.getString("title")));
		title.add(temp, 0, 0);
		return title;
	}

	private GridPane initLoader() {
		GridPane list = new GridPane();
		goButton = new Button("Go");
		goButton.setFont(font);
		goButton.setOnMouseClicked(e -> start());
		loader = makeLanguageBox();
		list.add(loader, 0, 0);
		list.add(goButton, 1, 0);
		list.setHgap(Integer.parseInt(myResources.getString("hgap")));
		return list;
	}

	private GridPane initButtons() {

		GridPane list = new GridPane();
		helpButton = new Button("help");
		settingsButton = new Button("settings");
		helpButton.setFont(font);
		settingsButton.setFont(font);
		list.add(helpButton, 0, 0);
		list.add(settingsButton, 1, 0);
		list.setHgap(Integer.parseInt(myResources.getString("hgap")));
		return list;
	}

	private Text createText(String s, int size) {
		Font font = Font.loadFont(getClass().getClassLoader().getResourceAsStream("unispace.ttf"), size);
		Text t = new Text(s);
		t.setFont(font);
		return t;
	}

	private void start() {
		if (loader.getValue() != null) {
			slogoScreen newScreen = new slogoScreen(loader.getValue());
			nextScreen = newScreen;
		} else {
			Alert uhoh = new Alert(AlertType.ERROR);
			uhoh.setTitle("whoops");
			uhoh.setContentText("please select a language");
			uhoh.showAndWait();
		}
	}

	@Override
	public void run() {
	}
}
