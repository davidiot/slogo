package slogo.commands;

import java.util.List;

import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public class IfElse extends Command {

	private final int CHILDREN_REQUIRED = 3;

	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		double expression = params.get(0).traverseAndExecute(controller);
		try {
			if (expression != 0) {
				return params.get(1).traverseAndExecute(controller);
			} else {
				return params.get(2).traverseAndExecute(controller);
			}
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}

}
