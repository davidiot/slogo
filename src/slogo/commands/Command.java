package slogo.commands;

import java.util.ArrayList;
import java.util.List;

import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public abstract class Command {
	
	protected String myName;
		
	public abstract double doCommand(List<NodeObject> params, EngineController controller);
	
	public abstract int getNumChildrenRequired();
	
	public boolean canGroup() {
		return false;
	}
	
	public List<Double> recurseToGetParameters(List<NodeObject> params, EngineController controller){
		List<Double> parameters = new ArrayList<Double>();
		for(NodeObject child: params) {
			parameters.add(child.traverseAndExecute(controller));
		}
		return parameters;
	}
	

	public String getName(){
		return myName;
	}

	
}
