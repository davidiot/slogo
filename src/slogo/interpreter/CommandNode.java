package slogo.interpreter;

import java.util.LinkedList;
import java.util.List;

import slogo.commands.Command;

public class CommandNode extends Node{
	private Command myAction;
	
	public CommandNode(Command action) {
		myAction = action;
	}
	
	public void addChild(Node child) {
		myChildren.add(child);
	}

	public double traverseAndExecute() {
		// TODO
		//return myAction.doCommand(params);
		return 0;
		
	}

	public boolean hasCompleteChildren() {
		// first check this node
		if (myAction != null) {
			if (myAction.getNumChildrenRequired() != myChildren.size()) return false;
		}
		// recursively check children
		boolean complete = true;
		for (Node child: myChildren) {
			complete = complete && child.hasCompleteChildren();
		}
		return complete;
	}

	public boolean canAdd() {
		if (myAction == null) return true;
		if (myChildren.size() >= myAction.getNumChildrenRequired()) return false;
		return true;
	}

	public void setParent(CommandNode parent) {
		myParent = parent;
		
	}

	public String getAction() {
		return myAction.toString();
	}

}
