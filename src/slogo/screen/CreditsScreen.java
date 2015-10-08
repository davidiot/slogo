package slogo.screen;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class CreditsScreen extends AbstractWindowScreen {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void makeScene() {
		root.add(makeTitle(), 0, 0);
		root.add(makeCredits(), 0, 1);
	}

	private GridPane makeTitle() {
		GridPane title = new GridPane();
		Text temp = createText(myResources.getString("creditsTitle"),
				Integer.parseInt(myResources.getString("smallTitle")));
		title.add(temp, 0, 0);
		return title;
	}

	private GridPane makeCredits() {
		GridPane credits = new GridPane();
		Text row1 = createText("Created for CS308 in Fall 2015 by:",
				Integer.parseInt(myResources.getString("subText")));
		Text row2 = createText("David Zhou",
				Integer.parseInt(myResources.getString("subText")));
		Text row3 = createText("Michael Daou",
				Integer.parseInt(myResources.getString("subText")));
		Text row4 = createText("Daniel McKee",
				Integer.parseInt(myResources.getString("subText")));
		Text row5 = createText("Daniel Pak",
				Integer.parseInt(myResources.getString("subText")));
		credits.add(row1, 0, 0);
		credits.add(row2, 0, 1);
		credits.add(row3, 0, 2);
		credits.add(row4, 0, 3);
		credits.add(row5, 0, 4);
		return credits;
	}

}
