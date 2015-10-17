package slogo.commands;

import java.util.ArrayList;
import java.util.List;

import slogo.character.CharacterInterface;
import slogo.nodes.NodeObject;

public abstract class Command {
		
	public abstract double doCommand(List<NodeObject> params, CharacterInterface character);
	
	public abstract int getNumChildrenRequired();
	
	public List<Double> recurseToGetParameters(List<NodeObject> params, CharacterInterface character){
		List<Double> parameters = new ArrayList<Double>();
		for(NodeObject child: params) {
			parameters.add(child.traverseAndExecute(character));
		}
		return parameters;
	}
	
}
