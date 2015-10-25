package slogo.commands;


public abstract class ArithmeticCommand extends Command {

	@Override
	public boolean canGroup() {
		return true;
	}

}
