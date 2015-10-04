package slogo.screen;


import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class StartScreen extends AbstractScreen {

	public StartScreen() {
		WIDTH = Integer.parseInt(myResources.getString("width"));
		HEIGHT = Integer.parseInt(myResources.getString("height"));
		root = new GridPane();
		scene = new Scene(root, WIDTH, HEIGHT);
		root.add(initTitle(), 0, 0);
		setAlignment(root);
	}

	private GridPane initTitle() {
		GridPane title = new GridPane();
		Text temp = createText("SLogo", Integer.parseInt(myResources.getString("title")));
		title.add(temp, 0, 0);
		return title;
	}

	private Text createText(String s, int size) {
		Font font = Font.loadFont(getClass().getClassLoader().getResourceAsStream("unispace.ttf"), size);
		Text t = new Text(s);
		t.setFont(font);
		return t;
	}

	@Override
	public void run() {
	}
}
