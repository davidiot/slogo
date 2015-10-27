package slogo.commands;

import java.util.List;
import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public class Product extends GroupingCommand {

	private final int CHILDREN_REQUIRED = 2;

	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		List<Double> parameters = recurseToGetParameters(params, controller);
		double product = 1;
		for (double param: parameters) {
			product = product * param;
		}
		return product;
	}

	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}
}
