package slogo.screen;

import javax.print.DocFlavor.URL;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class HelpScreen extends AbstractWindowScreen {

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
		WebView browser = new WebView();
		WebEngine webEngine = browser.getEngine();
		java.net.URL resourceURL = Thread.currentThread().getContextClassLoader().getResource("helpPage/SLogoHelp.html");
		String test = "file:///" + resourceURL.getFile();
		System.out.println(test);
		webEngine.load(test);
		title.getChildren().add(browser);
		//Text temp = createText(myResources.getString("helpTitle"),
		//		Integer.parseInt(myResources.getString("smallTitle")));
		//title.add(temp, 0, 0);
		return title;
	}

}
