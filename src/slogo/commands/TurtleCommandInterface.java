package slogo.commands;

import slogo.character.MainCharacter;
import slogo.interpreter.EngineController;

public interface TurtleCommandInterface {
	
	public double doTurtling(MainCharacter turtle, EngineController controller);

}
