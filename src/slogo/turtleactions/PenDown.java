package slogo.turtleactions;

import java.util.List;

import slogo.character.MainCharacter;
import slogo.commands.Command;

public class PenDown extends Command {

	public PenDown(MainCharacter character) {
		super(character);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double doCommand(List<Double> params) {
		System.out.println("Pen is down");
		return 1;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 0;
	}

}
