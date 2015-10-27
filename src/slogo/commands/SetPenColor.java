package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;
import slogo.element.Display;
import slogo.interpreter.EngineController;

public class SetPenColor extends TurtleCommand {
	private final int CHILDREN_REQUIRED = 1;
	
	public double doTurtling(MainCharacter turtle, EngineController controller) {
		List<Double> parameters = this.recurseToGetParameters(myParams, controller);
		double index = parameters.get(0);
		int indexInt = (int) index;
		String color = controller.getDisplay().convertIndexToHex(indexInt);
		controller.getMainCharacter().changePenColor(color);
		return index;
	}

	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}

}
