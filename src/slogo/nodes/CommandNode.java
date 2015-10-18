
package slogo.nodes;

import slogo.character.CharacterInterface;
import slogo.commands.Command;
import slogo.interpreter.EngineController;

public class CommandNode extends NodeObject{
	private Command myCommand;
	
	public CommandNode(String value, Command command, NodeObject parent) {
		super(value, parent);
		myCommand = command;
	}
	
	public void addChild(NodeObject child) {
		myChildren.add(child);
	}

	public double traverseAndExecute(EngineController controller) {
		return myCommand.doCommand(myChildren, controller);
		
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
