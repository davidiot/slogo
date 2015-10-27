package slogo.commands;

import slogo.character.MainCharacter;
import slogo.interpreter.EngineController;

public class IsPenDown extends TurtleCommand {
	
	private final int CHILDREN_REQUIRED = 0;
	
//	@Override
//	public double doCommand(List<NodeObject> params, EngineController controller) {
//		boolean isPenDown = (controller.getMainCharacter().isPenDown());
//		if (isPenDown)
//			return 1;
//		return 0;
//	}

	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}

	@Override
	public double doTurtling(MainCharacter turtle, EngineController controller) {
		boolean isPenDown = (turtle.isPenDown());
		if (isPenDown)
			return 1;
		return 0;
	}
	
	

}
