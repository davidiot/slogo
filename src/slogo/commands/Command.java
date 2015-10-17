package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;
import slogo.nodes.Node;

public abstract class Command {
		
	public abstract double doCommand(List<Node> params);
	
	public abstract int getNumChildrenRequired();
	
}
