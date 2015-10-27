package slogo.interpreter;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import slogo.commands.Command;
import slogo.commands.MakeUserInstruction;
import slogo.commands.MakeVariable;
import slogo.commands.UserInstruction;

public class CommandLibrary {

	private final String DEFAULT_RESOURCE_PACKAGE = "resources/languages/English3";
	private Map<String, Command> myCommandMap;
	private Map<String, String> myUserCommandMap;
	private ResourceBundle myCommandResources;

	// need to add MainCharacter as a parameter to constructor
	// once interface is up and running
	public CommandLibrary(VariableLibrary variables) {
		myCommandResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE);
		makeCommandMap(myCommandResources);
		myUserCommandMap = new HashMap<String, String>();
	}

	public Command getCommand(String name) {
		return myCommandMap.get(name);
	}
	
	public Map<String, String> getCustomCommandMap(){
		return myUserCommandMap;
	}

	private void makeCommandMap(ResourceBundle commandResources) {
		myCommandMap = new HashMap<String, Command>();
		Enumeration<String> commandNames = commandResources.getKeys();
		while (commandNames.hasMoreElements()) {
			String commandName = commandNames.nextElement();
			try {
				Class commandClass = Class.forName("slogo.commands." + commandName);
				Command command = (Command) commandClass.newInstance();
				addCommand(commandName, command);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	public void addCommand(String name, Command command) {
		if (command instanceof slogo.commands.UserInstruction){
			addCustomCommandToMap(name, (UserInstruction) command);
		}
		myCommandMap.put(name, command);
	}
	
	private void addCustomCommandToMap(String name, UserInstruction customCommand){
		String stringCommand = "to" + " " + customCommand.getName() + " "  + customCommand.getParameters() 
			+ " " + customCommand.getCommandTree().getTreeStringRepresentation();
		myUserCommandMap.put(name, stringCommand);
	}
	
}
