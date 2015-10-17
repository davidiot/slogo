package slogo.nodes;

import slogo.character.MainCharacter;
import slogo.interpreter.VariableLibrary;


public class VariableNode extends NodeObject {
	private String myName;
	private VariableLibrary myVariables;

	public VariableNode(VariableLibrary variables, NodeObject parent, String name) {
		super(parent);
		myName = name;
		myVariables = variables;
	}

	@Override
	public boolean hasCompleteChildren() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void addChild(NodeObject node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canAdd() {
		return false;
	}

	@Override
	public double traverseAndExecute(MainCharacter character) {
		if (myVariables.getVariable(myName) != null ) {
			return myVariables.getVariable(myName);
		}
		return getLocalVariable();
	}
	
	private double getLocalVariable() {
		System.out.println("looking for local variables... ");
		// TODO add variable search through parents
		// TODO add exception if variable not found
		return 0;
	}

	public String getName() {
		return myName;
	}

}
