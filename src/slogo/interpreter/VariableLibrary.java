package slogo.interpreter;

import java.util.HashMap;
import java.util.Map;

import slogo.element.ObservableArrayList;

public class VariableLibrary {
	private Map<String, Double> myVariableMap;
	private String myNewestVariable;
	
	public VariableLibrary(){
		myVariableMap = new HashMap<>();
	}
	
	public Double getVariable(String name) {
		return myVariableMap.get(name);
	}
	
	public void addVariable(String name, double value) {
		String newVariableMapping = name.substring(1) + " = " + value;
		myNewestVariable = newVariableMapping;
		myVariableMap.put(name, value);
		
		System.out.println(name + " is " + new Double(value));
	}
	
	public void updateVariablesFromGUI(ObservableArrayList variables){
		
	}
	
	public String getNewestVariableString(){
		return myNewestVariable;
	}
	
	public Map<String, Double> getVariableMap(){
		return myVariableMap;
	}

}
