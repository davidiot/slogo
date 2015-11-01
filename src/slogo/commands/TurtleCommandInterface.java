
package slogo.commands;

import slogo.character.MainCharacter;

@FunctionalInterface

public interface TurtleCommandInterface {
	
	public double doTurtling(MainCharacter turtle);

}
