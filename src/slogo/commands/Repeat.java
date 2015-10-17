package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;
import slogo.nodes.NodeObject;

public class Repeat extends Command {

	@Override
	public double doCommand(List<NodeObject> params, MainCharacter character) {
		double returnVal = 0; 
		// TODO add wrong node type checking
		int numRepeats = (int)params.get(0).traverseAndExecute(character);
		System.out.println(numRepeats);
		// body of loop should have start list (open bracket) as parent
		NodeObject body = params.get(1);
		for (int i = 0; i < numRepeats; i ++ ){
			returnVal = body.traverseAndExecute(character);
		}
		
		return returnVal;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 2;
	}

}
