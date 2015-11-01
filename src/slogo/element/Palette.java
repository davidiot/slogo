// This entire file is part of my masterpiece.
// Daniel Pak

package slogo.element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JButton;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Palette extends AbstractElement {

	private final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	private ResourceBundle myColors = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "color");
	private List<Color> colors;
	private GridPane display;
	private int limit = 3;

	public Palette(GridPane pane) {
		super(pane);
		String[] colorArray = myColors.getString("Colors").split(",");
		colors = new ArrayList<Color>();
		for(String s: colorArray){
			colors.add(Color.valueOf(s));
		}
		makePane();
	}

	protected void makePane() {
		display = new GridPane();
		int j = 0;
		int k = 0;
		while (j < colors.size()) {
			for (int i = 0; i < limit; i++) {
				PaletteSquare temp = new PaletteSquare(colors.get(j), j);
				display.add(temp, j % limit, k);
				j++;
			}
			k++;
		}
		this.pane.getChildren().add(display);
	}

	public String getColor(int i) {
		if (i < colors.size()) {
			return colors.get(i).toString();
		} else
			// DEFAULT
			return colors.get(0).toString();
	}

	public void setColor(int i, Color c) {
		colors.set(i, c);
	}

}
