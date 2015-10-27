package slogo.commands;

import java.util.List;

import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public class SetBackgroundColor extends Command {
	private final int CHILDREN_REQUIRED = 0;
	
	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		//controller.getScreen().getDisplay().
		//return params.get(0).traverseAndExecute(controller);
		return 0;
	}

	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}

}
