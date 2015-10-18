package slogo.commands;

import java.util.List;
import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public class Random extends Command {

	private final int CHILDREN_REQUIRED = 1;

	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		List<Double> parameters = recurseToGetParameters(params, controller);
		return parameters.get(0)*Math.random();
	}

	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}
	
}
