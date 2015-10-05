package slogo.element;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Canvas extends AbstractElement {

	private Rectangle map;

	public Canvas(GridPane pane) {
		super(pane);
	}

	@Override
	protected void makePane() {
		map = new Rectangle(Integer.parseInt(slogoResources.getString("mapWidth")),
				Integer.parseInt(slogoResources.getString("mapHeight")), Paint.valueOf(slogoResources.getString("mapColor")));
		pane.add(map, 0, 0);
	}

}
