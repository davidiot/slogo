package slogo.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * This class keeps a map of newly defined user commands with their 
 * corresponding number of parameters. This map is populated during
 * parsing so that the command tree can be built correctly (giving
 * newly defined commands the appropriate number of parameters).
 * 
 */

public class TemporaryCommandLibrary {
	private Map<String, Integer> commandMap;
	
	public TemporaryCommandLibrary() {
		commandMap = new HashMap<>();
	}
	
	public Integer getNumParameters(String name) {
		return commandMap.get(name);
	}

	public void addCommand(String name, int paramCount) {
		commandMap.put(name, paramCount);
	}

}
