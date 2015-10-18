package slogo.commands;

import java.util.List;

import slogo.character.CharacterInterface;
import slogo.character.MainCharacter;
import slogo.interpreter.EngineController;
import slogo.nodes.*;


public class HideTurtle extends Command {

	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		return 0;
		//double distanceMoved = params.get(0);
		//System.out.println("Turtle hidden.");
		//return distanceMoved;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 0;
	}

}
