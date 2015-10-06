package slogo.screen;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class SettingsScreen extends AbstractWindowScreen {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void makeScene() {
		root.add(makeTitle(), 0, 0);
	}

	private GridPane makeTitle() {
		GridPane title = new GridPane();
		Text temp = createText(myResources.getString("settingsTitle"),
				Integer.parseInt(myResources.getString("smallTitle")));
		title.add(temp, 0, 0);
		return title;
	}

}
