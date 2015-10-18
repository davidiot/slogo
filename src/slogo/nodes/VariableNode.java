package slogo.nodes;

import slogo.character.CharacterInterface;
import slogo.interpreter.VariableLibrary;


public class VariableNode extends NodeObject {
//	private String myName;
	private VariableLibrary myVariables;

	public VariableNode(String name, NodeObject parent, VariableLibrary variables) {
		super(name, parent);
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
	public double traverseAndExecute(CharacterInterface character) {
		if (myVariables.getVariable(myName) != null ) {
			return myVariables.getVariable(myName);
		}
		return getLocalVariable();
	}
	
	private double getLocalVariable() {
		System.out.println("looking for local variables... ");
		NodeObject currentNode = this.getParent();
		while (currentNode != null) {
			if (currentNode.getLocalVariable(myName) != null) {
				return currentNode.getLocalVariable(myName);
			}
			currentNode = currentNode.getParent();
		}
		// TODO throw exception variable does not exist;
		return 0;
	}

//	public String getName() {
//		return myName;
//	}

}
