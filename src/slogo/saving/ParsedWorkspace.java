package slogo.saving;

import slogo.element.Commands;
import slogo.element.History;
import slogo.element.Variables;
import slogo.interpreter.CommandLibrary;
import slogo.interpreter.VariableLibrary;

public class ParsedWorkspace {

	private CommandLibrary myCommandsLibrary;
	private VariableLibrary myVariablesLibrary;
	
	public ParsedWorkspace(CommandLibrary commands, VariableLibrary variables) {
			myVariablesLibrary = variables;
			myCommandsLibrary = commands;	
	}
  
}
