package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;

public abstract class Command {
	
	protected MainCharacter myCharacter;
	
	public abstract double doCommand(MainCharacter character, List<Double> params);
	
	public abstract int getNumChildrenRequired();
	
}
