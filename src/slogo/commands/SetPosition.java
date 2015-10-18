package slogo.commands;

import java.util.List;

import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;


public class SetPosition extends Command {

	private final int CHILDREN_REQUIRED = 2;
	
	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		List<Double> parameters = this.recurseToGetParameters(params, controller);
		double xDestination = parameters.get(0);
		double yDestination = parameters.get(1);
		return controller.getMainCharacter().goTo(xDestination, yDestination);
	}

	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}

}
