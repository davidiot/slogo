package slogo.commands;

import java.util.List;

import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public class Forward extends Command {
	
	private final int CHILDREN_REQUIRED = 1;


	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		List<Double> parameters = recurseToGetParameters(params, controller);
		double distance = parameters.get(0);
		controller.getMainCharacter().move(distance);
		return distance;
	}

	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}


}
