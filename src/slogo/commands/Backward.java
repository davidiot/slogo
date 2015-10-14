package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;

public class Backward extends Command {

	public Backward(MainCharacter character) {
		super(character);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double doCommand(List<Double> params) {
		double distanceMoved = params.get(0);
		System.out.println("Moved backward " + distanceMoved);
		return distanceMoved;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 1;
	}

}