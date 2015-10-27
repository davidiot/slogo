package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;
import slogo.interpreter.EngineController;

public class SetShape extends TurtleCommand {
	private final int CHILDREN_REQUIRED = 1;
	
	public double doTurtling(MainCharacter turtle, EngineController controller) {
		List<Double> parameters = this.recurseToGetParameters(myParams, controller);
		double index = parameters.get(0);
		int indexInt = (int) index;
		return index;
	}

	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}

}
