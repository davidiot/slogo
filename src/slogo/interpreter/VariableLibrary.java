package slogo.interpreter;

import java.util.HashMap;
import java.util.Map;

public class VariableLibrary {
	Map<String, Double> variableMap;
	
	public VariableLibrary(){
		variableMap = new HashMap<>();
	}
	
	public Double getVariable(String name) {
		return variableMap.get(name);
	}
	
	public void addVariable(String name, double value) {
		variableMap.put(name, value);
		System.out.println(name + " is " + new Double(value));
	}

}
