package slogo.commands;

import java.util.List;

import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public class Power extends Command {

	private final int CHILDREN_REQUIRED = 2;

	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		List<Double> parameters = recurseToGetParameters(params, controller);
		double base = parameters.get(0);
		double exponent = parameters.get(1);
		return Math.pow(base, exponent);
	}

	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}

}
