package slogo.commands;

import java.util.List;

import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;


public class Right extends Command {

	private final int CHILDREN_REQUIRED = 1;

	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		List<Double> parameters = this.recurseToGetParameters(params, controller);
		double degrees = parameters.get(0);
		return controller.getMainCharacter().rotateCharacter(degrees);
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return CHILDREN_REQUIRED;
	}

}
