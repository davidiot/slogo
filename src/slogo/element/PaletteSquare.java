package slogo.element;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PaletteSquare extends StackPane {
	
	private Color c; 
	private Rectangle rect;
	
	public PaletteSquare(Color c, int i){
		rect = new Rectangle(30, 30, c);
		Text text = new Text(Integer.toString(i));
		this.getChildren().addAll(rect, text);
		this.setOnMouseClicked(e-> selectNewColor());
	}

	public void selectNewColor(){
		Stage picker = new Stage();
		GridPane panel = new GridPane();
		Scene temp = new Scene(panel);
		ColorPicker colorPicker = new ColorPicker();
		panel.add(colorPicker, 0, 0);
		picker.setScene(temp);
		picker.setTitle("Color Picker");
		picker.show();
		colorPicker.setOnAction(e-> rect.setFill(colorPicker.getValue()));
	}
	
}
