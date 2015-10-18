package slogo.commands;

import java.util.List;

import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public class Heading extends Command {
	
	private final int CHILDREN_REQUIRED = 0;
	
	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		return controller.getMainCharacter().getDirection();
	}

	@Override
	public int getNumChildrenRequired() {
		return this.CHILDREN_REQUIRED;
	}

}
