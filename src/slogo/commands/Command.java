package slogo.commands;

import java.util.List;

import slogo.character.CharacterInterface;
import slogo.nodes.NodeObject;

public abstract class Command {
		
	public abstract double doCommand(List<NodeObject> params, CharacterInterface character);
	
	public abstract int getNumChildrenRequired();
	
}
