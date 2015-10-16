package slogo.commands;

import java.util.List;

import slogo.nodes.Node;

public class Repeat extends Command {

	@Override
	public double doCommand(List<Node> params) {
		double returnVal = 0; 
		// TODO add wrong node type checking
		int numRepeats = (int)params.get(0).traverseAndExecute();
		System.out.println(numRepeats);
		// body of loop should have start list (open bracket) as parent
		Node body = params.get(1);
		for (int i = 0; i < numRepeats; i ++ ){
			returnVal = body.traverseAndExecute();
		}
		
		return returnVal;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 2;
	}

}
