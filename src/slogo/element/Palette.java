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

public class Palette extends AbstractElement {
	
	private List<Color> colors; 
	private GridPane display; 
	private int limit = 3;

	public Palette(GridPane pane) {
		super(pane);
		colors = new ArrayList<Color>();
		colors.addAll(Arrays.asList(Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, Color.ORANGE,
				Color.PURPLE, Color.BLACK, Color.WHITE, Color.FIREBRICK));
		makePane();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected void makePane() {
		display = new GridPane();
		 final ColorPicker colorPicker = new ColorPicker();
		 colorPicker.setOnAction(new EventHandler() {
		     public void handle(Event t) {
		         Color c = colorPicker.getValue();
		         System.out.println("New Color's RGB = "+c.getRed()+" "+c.getGreen()+" "+c.getBlue());
		     }
		 });
		int j = 0;
		int k = 0;
		while(j < colors.size()){
			for(int i = 0; i<limit; i++){
				StackPane stack = new StackPane();
				Text text = new Text(Integer.toString(j));
				Rectangle image = new Rectangle(20, 20, colors.get(j));
				stack.getChildren().addAll(image, text);
				stack.setOnMouseClicked(e->System.out.println("blah"));
				display.add(stack, k, j%limit);
				j++;
			}	
			k++;
		}
		display.setOnMouseClicked(e -> System.out.println("check"));
		this.pane.getChildren().add(display);
	}

}
