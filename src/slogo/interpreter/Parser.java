package slogo.interpreter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Parser {

	private HashMap<String, String[]> myCommandMap;

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
