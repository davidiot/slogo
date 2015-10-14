package slogo.nodes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import slogo.character.MainCharacter;
import slogo.commands.Command;
import slogo.element.Display;

public class CommandNode extends Node{
	private Command myAction;
	private List<Double> myParameters;
	
	public CommandNode(Command action, Node parent) {
		super(parent);
		myAction = action;
		myParameters = new ArrayList<>();
	}
	
	public void addChild(Node child) {
		myChildren.add(child);
	}

	public double traverseAndExecute() {
		for (Node child: myChildren){
			System.out.println(myChildren);
			myParameters.add(child.traverseAndExecute());
		}
		return myAction.doCommand(myParameters);
		
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
