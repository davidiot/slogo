package slogo.commands;

import slogo.character.MainCharacter;
import slogo.interpreter.EngineController;

@FunctionalInterface

public interface TurtleCommandInterface {
	
	public double doTurtling(MainCharacter turtle);

}
