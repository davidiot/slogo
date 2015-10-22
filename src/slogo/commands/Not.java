package slogo.commands;

import java.util.List;
import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public class Not extends Command {
	
	private final int CHILDREN_REQUIRED = 1;

	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		List<Double> parameters = recurseToGetParameters(params, controller);
		boolean isZero = parameters.get(0).equals(0.0);
		if (isZero)
			return 1;
		return 0;
	}

	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}

}
