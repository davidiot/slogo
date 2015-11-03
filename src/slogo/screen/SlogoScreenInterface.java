package slogo.screen;

import javafx.scene.layout.GridPane;
import slogo.element.Commands;
import slogo.element.Display;
import slogo.element.DisplayInterface;
import slogo.element.History;
import slogo.element.Variables;

public interface SlogoScreenInterface extends AbstractScreenInterface {

	public void run();

	public GridPane makeTitle();

	public void makeLists();
	
	public History getHistoryObject();
	
	public Variables getVariablesObject();
	
	public Commands getCommandsObject();
	
	public DisplayInterface getDisplay();
	
	public double clearMap();
	
	
}
