package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;

public class Forward extends Command {

	// just for testing until MainCharacter works
	// DELETE THIS
	public Forward() {
		super(null);
		// TODO Auto-generated constructor stub
	}

	//	public Forward(MainCharacter character) {
	//		super(character);
	//		// TODO Auto-generated constructor stub
	//	}	

	private int NUM_PARAMETERS = 1;

	@Override
	public double doCommand(List<Double> params) {
		// TODO Auto-generated method stub
		System.out.println("doing forward");
		return 0;
	}

	@Override
	public int getNumChildrenRequired() {
		return NUM_PARAMETERS;
	}

}
