package slogo.commands;

import java.util.ArrayList;
import java.util.List;

import slogo.character.MainCharacter;
import slogo.interpreter.VariableLibrary;
import slogo.nodes.Node;

public class Forward extends Command {
	
	private VariableLibrary myVariables;
	
//	@Override
//	public double doCommand(List<Double> params) {
//		double distanceMoved = params.get(0);
//		System.out.println("Moved forward " + distanceMoved);
//		return distanceMoved;
//	}
	
	public Forward() {
		
	}

	public Forward(VariableLibrary variables) {
		myVariables = variables;
	}

	@Override
	public double doCommand(List<Node> params) {
		List<Double> parameters = new ArrayList<Double>();
		for(Node child: params) {
			parameters.add(child.traverseAndExecute());
		}
		double distanceMoved = parameters.get(0);
		System.out.println("Moved forward " + distanceMoved);
		return distanceMoved;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 1;
	}


}
