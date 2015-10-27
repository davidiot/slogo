package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;
import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public class HideTurtle extends TurtleCommand {
	
private final int CHILDREN_REQUIRED = 0;

//	@Override
//	public double doCommand(List<NodeObject> params, EngineController controller) {
//		return controller.getMainCharacter().setHidden(false);
//	}

	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}

@Override
public double doTurtling(MainCharacter turtle, EngineController controller) {
	return turtle.setHidden(false);
}

}
