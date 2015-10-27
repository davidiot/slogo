package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;
import slogo.interpreter.EngineController;

public class GetShape extends TurtleCommand {
	private final int CHILDREN_REQUIRED = 0;
	
	public double doTurtling(MainCharacter turtle, EngineController controller) {
		return turtle.getShape();
	}

	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}

}
