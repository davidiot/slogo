package slogo.commands;

import java.util.List;

import slogo.character.CharacterInterface;
import slogo.character.MainCharacter;
import slogo.interpreter.RunCommandException;
import slogo.nodes.ListStartNode;
import slogo.nodes.NodeObject;

public class Repeat extends Command {

	@Override
	public double doCommand(List<NodeObject> params, CharacterInterface character) {
		double returnVal = 0; 
		int numRepeats = (int)params.get(0).traverseAndExecute(character);
		// body of loop should have start list (open bracket) as parent
		NodeObject body = params.get(1);
		if (! (body instanceof ListStartNode)) {
			throw new RunCommandException("Expected [ for repeat loop");
		}
		for (int i = 0; i < numRepeats; i ++ ){
			returnVal = body.traverseAndExecute(character);
		}
		
		return returnVal;
	}

	@Override
	public int getNumChildrenRequired() {
		return 2;
	}

}
