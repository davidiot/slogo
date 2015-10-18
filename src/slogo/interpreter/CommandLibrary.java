package slogo.interpreter;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import slogo.commands.Command;
import slogo.commands.MakeUserInstruction;
import slogo.commands.MakeVariable;

public class CommandLibrary {

	private final String DEFAULT_RESOURCE_PACKAGE = "resources/languages/English3";
	private Map<String, Command> myCommandMap;
	private ResourceBundle myCommandResources;

	// need to add MainCharacter as a parameter to constructor
	// once interface is up and running
	public CommandLibrary(VariableLibrary variables) {
		myCommandResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE);
		makeCommandMap(myCommandResources);
		// TODO fix following code (sorry for marring the beautiful code in this class)
		myCommandMap.put("MakeVariable", new MakeVariable(variables));
		myCommandMap.put("MakeUserInstruction", new MakeUserInstruction());
	}

	public Command getCommand(String name) {
		return myCommandMap.get(name);
	}

	private void makeCommandMap(ResourceBundle commandResources) {
		myCommandMap = new HashMap<String, Command>();
		Enumeration<String> commandNames = commandResources.getKeys();
		while (commandNames.hasMoreElements()) {
			String commandName = commandNames.nextElement();
			try {
				Class commandClass = Class.forName("slogo.commands." + commandName);
				Command command = (Command) commandClass.newInstance();
				myCommandMap.put(commandName, command);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	public void addCommand(String name, Command command) {
		myCommandMap.put(name, command);
	}

}
