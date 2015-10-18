package slogo.commands;

import java.util.List;

import slogo.character.CharacterInterface;
import slogo.character.MainCharacter;
import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public class Repeat extends Command {

	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		double returnVal = 0; 
		// TODO add wrong node type checking
		int numRepeats = (int)params.get(0).traverseAndExecute(controller);
		System.out.println(numRepeats);
		// body of loop should have start list (open bracket) as parent
		NodeObject body = params.get(1);
		for (int i = 0; i < numRepeats; i ++ ){
			returnVal = body.traverseAndExecute(controller);
		}
		
		return returnVal;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 2;
	}

}
