package slogo.nodes;

import slogo.interpreter.EngineController;
import slogo.interpreter.InterpreterException;
import slogo.interpreter.VariableLibrary;


public class VariableNode extends NodeObject {
//	private String myName;
	private VariableLibrary myVariables;

	// NOW CAN CHANGE CONSTRUCTOR TO MATCH EVERYTHING ELSE?
	public VariableNode(String name, String rawString, NodeObject parent) {
		super(name, rawString, parent);
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
	public double traverseAndExecute(EngineController controller) {
		try {
			return getLocalVariable();
		} catch (InterpreterException e) {
			myVariables = controller.getVariableLibrary();
			if (myVariables.getVariable(myName) != null ) {
				return myVariables.getVariable(myName);
			}
		}
//		throw new InterpreterException("Variable %s not found", myName);
		return 0;
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
		throw new InterpreterException("Local variable %s not found", myName);
	}

}
