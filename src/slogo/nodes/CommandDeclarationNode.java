package slogo.nodes;

import slogo.interpreter.ControlInterface;

public class CommandDeclarationNode extends NodeObject {
//	private String commandName; 
	
	public CommandDeclarationNode(String value, String rawString, NodeObject parent) {
		super(value, rawString, parent);
	}

	@Override
	public boolean hasCompleteChildren() {
		return true;
	}

	@Override
	public void addChild(NodeObject node) {
		return;
	}

	@Override
	public boolean canAdd() {
		return false;
	}

	@Override
	public double traverseAndExecute(ControlInterface controller) {
		return 0;
	}

}
