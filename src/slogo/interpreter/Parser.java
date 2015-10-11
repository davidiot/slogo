package slogo.interpreter;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * This class acts acts as both a way to translate commands
 * in different languages into their default form and to 
 * check that all inputs match some correct syntax form. 
 * 
 */

public class Parser {

	private final String DEFAULT_RESOURCE_PACKAGE = "resources/languages/";
    private ResourceBundle myCommandResources;

	private HashMap<String, String> myCommandMap;
	
	public Parser(String language){
		myCommandResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
		//System.out.println(myCommandResources.getString("Forward"));
		makeCommandMap(myCommandResources);
	}
	
	public String[] parseCommands(String input) {
		String[] splitArray = input.split("\\s+");
		for (int i = 0; i<splitArray.length; i++){
			splitArray[i] = splitArray[i].toLowerCase();
		}
		
		if (checkForInvalidCommands(splitArray)!=null){
			//throw checkForInvalidCommands(splitArray);
		}
		
		return splitArray;
	}
	
	private void makeCommandMap(ResourceBundle commandResources){
		myCommandMap = new HashMap<String, String>();
		Enumeration<String> commandNames = commandResources.getKeys();
		while (commandNames.hasMoreElements()){
			String commandName = commandNames.nextElement();
			String commandCodes = commandResources.getString(commandName);
			//System.out.println(commandCodes);
			String[] commandCodeArray = commandCodes.split("\\|");
			for (String s: commandCodeArray){
				myCommandMap.put(s, commandName);
				System.out.println(s + " " + commandName);
			}
		}
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
