package slogo.screen;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class StartScreen extends AbstractScreen {
	private ComboBox<String> loader;
	private Button goButton;
	private Button helpButton;
	private Button settingsButton;
	private Button creditsButton;

	public StartScreen() {
		WIDTH = Integer.parseInt(myResources.getString("width"));
		HEIGHT = Integer.parseInt(myResources.getString("height"));
		root = new GridPane();
		scene = new Scene(root, WIDTH, HEIGHT);
		root.add(makeTitle(), 0, 0);
		root.add(makeLoader(), 0, 1);
		root.add(makeButtons(), 0, 2);
		setAlignment(root);
		root.setVgap(Integer.parseInt(myResources.getString("vgap")));
		this.title = myResources.getString("defaultTitle");
	}

	private GridPane makeTitle() {
		GridPane title = new GridPane();
		Text temp = createText("SLogo",
				Integer.parseInt(myResources.getString("title")));
		title.add(temp, 0, 0);
		return title;
	}

	private GridPane makeLoader() {
		GridPane list = new GridPane();
		goButton = new Button(myResources.getString("go"));
		goButton.setFont(font);
		goButton.setOnMouseClicked(e -> start());
		loader = makeLanguageBox();
		list.add(loader, 0, 0);
		list.add(goButton, 1, 0);
		list.setHgap(Integer.parseInt(myResources.getString("hgap")));
		return list;
	}

	private GridPane makeButtons() {

		GridPane list = new GridPane();
		helpButton = makeHelpButton();
		settingsButton = makeSettingsButton();
		creditsButton = makeCreditsButton();
		list.add(helpButton, 0, 0);
		list.add(settingsButton, 1, 0);
		list.add(creditsButton, 2, 0);
		list.setHgap(Integer.parseInt(myResources.getString("hgap")));
		return list;
	}

	private void start() {
		if (loader.getValue() != null) {
			SlogoScreen newScreen = new SlogoScreen(loader.getValue());
			nextScreen = newScreen;
		} else {
			Alert uhoh = new Alert(AlertType.ERROR);
			uhoh.setTitle(myResources.getString("error"));
			uhoh.setContentText(myResources.getString("prompt"));
			uhoh.showAndWait();
		}
	}

	@Override
	public void run() {
	}
}
