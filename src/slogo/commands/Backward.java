package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;
import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public class Backward extends Command implements TurtleCommandInterface {
	
	private final int CHILDREN_REQUIRED = 1;
	double distance;
	
	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		List<Double> parameters = recurseToGetParameters(params, controller);
		distance = parameters.get(0);
		//controller.getMainCharacter().move(distance, false);
		controller.commandTurtles(this);
		return distance;
	}

	@Override
	public void doTurtling(MainCharacter turtle) {
		turtle.move(distance, false);
	}
	
	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}

}
