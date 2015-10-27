package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;
import slogo.interpreter.EngineController;

public class Stamp extends TurtleCommand {
	private final int CHILDREN_REQUIRED = 0;
	
	public double doTurtling(MainCharacter turtle, EngineController controller) {
		return 0;
	}

	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}

}
