package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;
import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public class Wrap extends Command {

	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		controller.getDisplay().setWrap(true);
		return 1;
	}

	@Override
	public int getNumChildrenRequired() {
		return 0;
	}


}
