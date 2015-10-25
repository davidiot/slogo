package slogo.commands;


public abstract class GroupingCommand extends Command {

	@Override
	public boolean canGroup() {
		return true;
	}

}
