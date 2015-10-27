package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;
import slogo.interpreter.EngineController;

public class SetTowards extends TurtleCommand {
	
	private final int CHILDREN_REQUIRED = 2;

//	@Override
//	public double doCommand(List<NodeObject> params, EngineController controller) {
//		List<Double> parameters = this.recurseToGetParameters(params, controller);
//		double xDestination = parameters.get(0);
//		double yDestination = parameters.get(1);
//		return controller.getMainCharacter().towards(xDestination, yDestination);
//	}

	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}

	@Override
	public double doTurtling(MainCharacter turtle, EngineController controller) {
		List<Double> parameters = this.recurseToGetParameters(myParams, controller);
		double xDestination = parameters.get(0);
		double yDestination = parameters.get(1);
		return turtle.towards(xDestination, yDestination);
	}

}
