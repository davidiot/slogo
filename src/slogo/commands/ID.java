package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;
import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public class ID extends Command {

	private final int CHILDREN_REQUIRED = 0;

	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		System.out.println(controller.getActiveID());
		return controller.getActiveID();
	}

	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}


}
