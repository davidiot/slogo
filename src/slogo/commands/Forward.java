package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;
import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public class Forward extends TurtleCommand{
	private final int CHILDREN_REQUIRED = 1;
	
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
