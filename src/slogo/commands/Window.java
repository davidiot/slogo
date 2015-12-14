package slogo.commands;

import java.util.List;

import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public class Window extends Command {

	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		controller.setWrappingProperty(false);
		return 2;
	}

	@Override
	public int getNumChildrenRequired() {
		return 0;
	}

}
