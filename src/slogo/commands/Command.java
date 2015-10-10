package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;

public abstract class Command {
	
	protected MainCharacter myCharacter;
	
	public Command(MainCharacter character) {
		myCharacter = character;
	}

	public abstract double doCommand(List<Double> params);
	
	public abstract int getNumChildrenRequired();
	
}
