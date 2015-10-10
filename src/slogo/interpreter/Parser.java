package slogo.interpreter;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class Parser {

	private final String DEFAULT_RESOURCE_PACKAGE = "resources/languages/";
    private ResourceBundle myCommandResources;

	private HashMap<String, String> myCommandMap;
	
	public Parser(String language){
		myCommandResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
		makeCommandMap(myCommandResources);
	}
	
	private void makeCommandMap(ResourceBundle commandResources){
		myCommandMap = new HashMap<String, String>();
		Enumeration<String> commandNames = commandResources.getKeys();
		while (commandNames.hasMoreElements()){
			String commandName = commandNames.nextElement();
			String commandCodes = commandResources.getString(commandName);
			String[] commandCodeArray = commandCodes.split("|");
			for (String s: commandCodeArray){
				myCommandMap.put(s, commandName);
			}
		}
	}

	public String[] parseCommands(String input) throws Exception {
		String[] splitArray = input.split("\\s+");
		if (checkForInvalidCommands(splitArray)!=null){
			throw checkForInvalidCommands(splitArray);
		}
		return splitArray;
		
	}

	private Exception checkForInvalidCommands(String[] splitArray) {
		for (String s : splitArray) {
			if (!(myCommandMap.containsKey(s))) {
				try {
					Double.parseDouble(s);
				} catch (NumberFormatException e) {
					return e;
				}
			}
		}
		return null;
	}

}
