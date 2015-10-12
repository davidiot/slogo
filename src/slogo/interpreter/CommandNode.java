package slogo.interpreter;

import java.util.LinkedList;
import java.util.List;

import slogo.commands.Command;

public class CommandNode {
	
	private CommandNode myParent;
	private List<CommandNode> myChildren;
	private Command myAction;
	
	public CommandNode(Command action) {
		myChildren = new LinkedList<CommandNode>();
		myAction = action;
	}
	
	public void addChild(CommandNode child) {
		myChildren.add(child);
	}

	public double traverseAndExecute() {
		
		return myAction.doCommand(params);
		
	}

	public boolean hasCompleteChildren() {
		// first check this node
		if (myAction != null) {
			if (myAction.getNumChildrenRequired() != myChildren.size()) return false;
		}
		// recursively check children
		boolean complete = true;
		for (CommandNode child: myChildren) {
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

	public List<CommandNode> getAllChildren() {
		return myChildren;
	}

	public String getAction() {
		return myAction.toString();
	}

}
