package slogo.interpreter;

public class InputObject {
	private String myType;
	private String myValue;
	
	public InputObject(String type, String expr) {
		myType = type;
		myValue = expr;
	}

	public String getValue(){
		return myValue;
	}
	
	public String getType(){
		return myType;
	}
	
	@Override 
	public boolean equals(Object obj) {
		if (! (obj instanceof InputObject)) return false;
		return myType.equals(((InputObject) obj).getType()) && myValue.equals(((InputObject) obj).getValue()); 
	}

	public void changeType(String type) {
		myType = type;
		
	}

}
