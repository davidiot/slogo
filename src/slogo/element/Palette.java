package slogo.element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import slogo.screen.AbstractScreen;

public class Palette extends AbstractDockElement {

	private List<Color> colors;
	private GridPane display;
	private int limit = 3;

	public Palette(GridPane pane, AbstractScreen screen) {
		super(pane, "Pallete", screen);
		colors = new ArrayList<Color>();
		colors.addAll(Arrays.asList(Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.VIOLET,
				Color.BLACK, Color.WHITE, Color.FIREBRICK));
		makePane();
	}

	protected void makePane() {
		GridPane mainPane = new GridPane();
		mainPane.add(titlePane, 0, 0);
		display = new GridPane();
		mainPane.add(display, 0, 1);
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
		this.pane.getChildren().add(mainPane);
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
