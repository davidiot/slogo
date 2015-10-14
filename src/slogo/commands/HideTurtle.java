package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;

public class HideTurtle extends Command {

	public HideTurtle(MainCharacter character) {
		super(character);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double doCommand(List<Double> params) {
		double distanceMoved = params.get(0);
		System.out.println("Turtle hidden.");
		return distanceMoved;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 0;
	}

}
