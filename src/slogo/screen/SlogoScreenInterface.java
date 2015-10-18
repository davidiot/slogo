package slogo.screen;

import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import slogo.element.Display;
import slogo.element.Commands;
import slogo.element.Console;
import slogo.element.History;
import slogo.element.ObservableArrayList;
import slogo.element.Variables;
import slogo.interpreter.EngineController;

public interface SlogoScreenInterface extends AbstractScreenInterface {

	public void run();

	public GridPane makeTitle();

	public void makeLists();
	
	public History getHistoryObject();
	
	public Variables getVariablesObject();
	
	public Commands getCommandsObject();
	
	public Display getDisplay();
	
	public void clearMap();
	
	
}
