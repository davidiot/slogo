package slogo.nodes;

import java.util.ArrayList;
import java.util.List;

import slogo.commands.Command;

public class CommandNode extends NodeObject{
	private Command myCommand;
	private List<Double> myParameters;
	
	public CommandNode(Command command, NodeObject parent) {
		super(parent);
		myCommand = command;
		myParameters = new ArrayList<>();
	}
	
	public void addChild(NodeObject child) {
		myChildren.add(child);
	}

	public double traverseAndExecute(MainCharacter character) {
//		for (Node child: myChildren){
//			System.out.println(myChildren);
//			myParameters.add(child.traverseAndExecute());
//		}
//		return myAction.doCommand(myParameters);
		return myCommand.doCommand(myChildren, character);
		
	}

	public boolean hasCompleteChildren() {
		// first check this node
		if (myCommand != null) {
			if (myCommand.getNumChildrenRequired() != myChildren.size()) return false;
		}
		// recursively check children
		boolean complete = true;
		for (NodeObject child: myChildren) {
			complete = complete && child.hasCompleteChildren();
		}
		return complete;
	}

	public boolean canAdd() {
		if (myCommand == null) return true;
		if (myChildren.size() >= myCommand.getNumChildrenRequired()) return false;
		return true;
	}

	public void setParent(CommandNode parent) {
		myParent = parent;
		
	}

	public String getAction() {
		return myCommand.toString();
	}

}
