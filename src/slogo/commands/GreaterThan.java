package slogo.commands;

import java.util.List;

import slogo.interpreter.ControlInterface;
import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public class GreaterThan extends Command {

	private final int CHILDREN_REQUIRED = 2;

	@Override
	public double doCommand(List<NodeObject> params, ControlInterface controller) {
		List<Double> parameters = recurseToGetParameters(params, controller);
		boolean isTrue = parameters.get(0) > parameters.get(1);
		if (isTrue)
			return 1;
		return 0;
	}

	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}
}
