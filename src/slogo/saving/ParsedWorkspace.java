package slogo.saving;

import java.util.Map;
import slogo.interpreter.CommandLibrary;
import slogo.interpreter.VariableLibrary;

public class ParsedWorkspace {

	private CommandLibrary myCommandsLibrary;
	private VariableLibrary myVariablesLibrary;
	
	public ParsedWorkspace(CommandLibrary commands, VariableLibrary variables) {
			myVariablesLibrary = variables;
			myCommandsLibrary = commands;	
	}
  
	public Map<String, String> getCustomCommands(){
		return myCommandsLibrary.getCustomCommandMap();
	}
	
	public Map<String, Double> getVariableMap(){
		return myVariablesLibrary.getVariableMap();
	}
}
