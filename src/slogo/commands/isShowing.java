package slogo.commands;

import java.util.List;

import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public class isShowing extends Command {

	private final int CHILDREN_REQUIRED = 0;

	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		boolean isShowing = !controller.getMainCharacter().isHidden();
		if (isShowing)
			return 1;
		return 0;
	}

	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}

}
