package slogo.commands;

import java.util.List;

import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public class DoTimes extends Command {

	private final int CHILDREN_REQUIRED = 2;

	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		double expression = params.get(0).traverseAndExecute(controller);
		double returnValue = 0;
		for (int i = 0; i< expression; i++){
			returnValue = params.get(1).traverseAndExecute(controller);
		}
		return returnValue;
	}

	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}
	
}
