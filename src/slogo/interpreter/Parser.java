package slogo.interpreter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class Parser {

	private final String DEFAULT_RESOURCE_PACKAGE = "resources/languages/";
    private ResourceBundle myCommandResources;

	private HashMap<String, String[]> myCommandMap;
	
	public Parser(String language){
		myCommandResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
	}
	
	private Map<String,String[]> makeCommandMap(ResourceBundle commandResources){
		
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
