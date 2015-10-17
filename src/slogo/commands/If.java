package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;
import slogo.nodes.NodeObject;

public class If extends Command {

	@Override
	public double doCommand(List<NodeObject> params, MainCharacter character) {
		// TODO Auto-generated method stub
		double expression = params.get(0).traverseAndExecute(character);
		if (expression != 0) {
			params.get(1).traverseAndExecute(character);
		}
		return 0;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 2;
	}

}
