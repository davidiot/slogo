package slogo.interpreter;

public interface ControlInterface {
	
	CommandLibrary getCommandLibrary();
	
	VariableLibrary getVariableLibrary();
	
	TurtleController getTurtleController();

}
