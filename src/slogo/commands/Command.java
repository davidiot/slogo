package slogo.commands;

import java.util.ArrayList;
import java.util.List;

import slogo.character.CharacterInterface;
import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public abstract class Command {
		
	public abstract double doCommand(List<NodeObject> params, EngineController controller);
	
	public abstract int getNumChildrenRequired();
	
	public List<Double> recurseToGetParameters(List<NodeObject> params, EngineController controller){
		List<Double> parameters = new ArrayList<Double>();
		for(NodeObject child: params) {
			parameters.add(child.traverseAndExecute(controller));
		}
		return parameters;
	}
	
}
