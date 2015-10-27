package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;
import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public class Forward extends Command implements TurtleCommandInterface {
	private List<NodeObject> myParams;
	private final int CHILDREN_REQUIRED = 1;
	//private double distance;

	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		myParams = params;
		//List<Double> parameters = recurseToGetParameters(params, controller);
		//distance = parameters.get(0);
		//return controller.getMainCharacter().move(distance, true);
		return controller.commandTurtles(this);
	}

	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}

	@Override
	public double doTurtling(MainCharacter turtle, EngineController controller) {
		List<Double> parameters = recurseToGetParameters(myParams, controller);
		double distance = parameters.get(0);
		turtle.move(distance, true);
		return distance;
		
	}


}
