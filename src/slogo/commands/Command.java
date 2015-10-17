package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;
import slogo.nodes.NodeObject;

public abstract class Command {
		
	public abstract double doCommand(List<NodeObject> params, MainCharacter character);
	
	public abstract int getNumChildrenRequired();
	
}
