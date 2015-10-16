package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;

public abstract class Command {
		
	public abstract double doCommand(List<Double> params);
	
	public abstract int getNumChildrenRequired();
	
}
