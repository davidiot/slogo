// This entire file is part of my masterpiece.
// Daniel McKee

package slogo.commands;

import slogo.character.CharacterInterface;

@FunctionalInterface

public interface TurtleCommandInterface {
	
	public double doTurtling(CharacterInterface turtle);

}
