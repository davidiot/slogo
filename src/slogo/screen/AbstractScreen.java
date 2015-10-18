package slogo.screen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import slogo.parameters.Parameters;

public abstract class AbstractScreen implements AbstractScreenInterface {
	protected GridPane root;
	protected Scene scene;
	protected int WIDTH;
	protected int HEIGHT;
	protected String title = "";
	protected AbstractScreen nextScreen = null;
	protected final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	protected ResourceBundle myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "screen");
	protected Font font = Font.loadFont(getClass().getClassLoader().getResourceAsStream("unispace.ttf"),
			Integer.parseInt(myResources.getString("buttons")));
	private HelpScreen help;
	private SettingsScreen settings;
	private CreditsScreen credits;

	// the window scenes and parameters are static because we want them to be
	// preserved across all screens

	private static boolean showingHelp = false;
	private static boolean showingSettings = false;
	private static boolean showingCredits = false;
	private static Stage settingsStage;
	private static Stage helpStage;
	private static Stage creditsStage;
	protected static Parameters parameters;

	abstract public void run();

	public Scene getScene() {
		return scene;
	}

	public AbstractScreen getNextScreen() {
		return nextScreen;
	}

	public String getTitle() {
		return title;
	}

	protected void setAlignment(GridPane r) {
		r.setAlignment(Pos.CENTER);
		for (Node n : r.getChildren()) {
			if (n instanceof GridPane) {
				setAlignment((GridPane) n);
			}
		}
	}

	protected ComboBox<String> makeLanguageBox() {
		ComboBox<String> box = new ComboBox<String>();
		box.setPromptText("Choose Language");
		box.setVisibleRowCount(3);
		box.setMinWidth(Integer.parseInt(myResources.getString("box")));
		Scanner s;
		ArrayList<String> list = new ArrayList<String>();
		try {
			s = new Scanner(new File("src/resources/languages.txt"));
			list = new ArrayList<String>();
			while (s.hasNext()) {
				list.add(s.next());
			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		box.getItems().addAll(list);
		return box;
	}

	protected Button makeBackButton() {
		Button button = new Button(myResources.getString("menu"));
		button.setFont(font);
		button.setOnMouseClicked(e -> returnToMenu());
		return button;
	}

	protected Button makeSettingsButton() {
		Button button = new Button(myResources.getString("settings"));
		button.setFont(font);
		button.setOnMouseClicked(e -> showSettings());
		return button;
	}

	protected Button makeHelpButton() {
		Button button = new Button(myResources.getString("help"));
		button.setFont(font);
		button.setOnMouseClicked(e -> showHelp());
		return button;
	}

	protected Button makeCreditsButton() {
		Button button = new Button(myResources.getString("credits"));
		button.setFont(font);
		button.setOnMouseClicked(e -> showCredits());
		return button;
	}

	private void returnToMenu() {
		StartScreen newScreen = new StartScreen();
		nextScreen = newScreen;
	}

	private void showHelp() {
		if (!showingHelp) {
			helpStage = new Stage();
			help = new HelpScreen();
			makeWindow(helpStage, help);
			showingHelp = true;
			helpStage.setOnCloseRequest(e -> closeHelp());
		}
		helpStage.toFront();
	}

	private void showSettings() {
		if (!showingSettings) {
			settingsStage = new Stage();
			settings = new SettingsScreen();
			makeWindow(settingsStage, settings);
			showingSettings = true;
			settingsStage.setOnCloseRequest(e -> closeSettings());
		}
		settingsStage.toFront();
	}

	private void showCredits() {
		if (!showingCredits) {
			creditsStage = new Stage();
			credits = new CreditsScreen();
			makeWindow(creditsStage, credits);
			showingCredits = true;
			creditsStage.setOnCloseRequest(e -> closeCredits());
		}
		creditsStage.toFront();
	}

	public void makeWindow(Stage stage, AbstractWindowScreen screen) {
		stage.setScene(screen.getScene());
		stage.setTitle(screen.getTitle());
		stage.show();
		stage.setResizable(false);
	}

	private void closeHelp() {
		showingHelp = false;
	}

	private void closeSettings() {
		showingSettings = false;
	}

	private void closeCredits() {
		showingCredits = false;
	}

	protected Text createText(String s, int size) {
		Font font = Font.loadFont(getClass().getClassLoader().getResourceAsStream("unispace.ttf"), size);
		Text t = new Text(s);
		t.setFont(font);
		return t;
	}

	protected void makeParameters() {
		parameters = new Parameters();
		try {
			Scanner s = new Scanner(new File("src/resources/settings.txt"));
			while (s.hasNext()) {
				String next = s.nextLine();
				if (next.equals("0")) {
					break;
				}
				String[] vals = s.nextLine().split(" ");
				parameters.setValue(next, Double.parseDouble(vals[0]));
			}
		} catch (

		FileNotFoundException e)

		{
			e.printStackTrace();
		}
	}

	protected void showError(String title, String message) {
		Alert uhoh = new Alert(AlertType.ERROR);
		uhoh.setTitle(title);
		uhoh.setContentText(message);
		uhoh.show();
	}
}
