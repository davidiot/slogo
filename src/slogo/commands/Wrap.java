package slogo.commands;

import java.util.List;
import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public class Wrap extends Command {

	@Override
	public int getNumChildrenRequired() {
		return 0;
	}

	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		controller.setWrappingProperty(true);
		return 1;
	}

}
