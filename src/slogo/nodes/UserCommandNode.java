package slogo.nodes;

import slogo.commands.Command;
import slogo.interpreter.CommandLibrary;
import slogo.interpreter.ControlInterface;

public class UserCommandNode extends NodeObject {
	private int numChildren;
	private CommandLibrary commandLibrary;

	public UserCommandNode(NodeObject parent, String name, String rawString, int numParams) {
		super(name, rawString, parent);
		numChildren = numParams;
	}

	@Override
	public boolean hasCompleteChildren() {
		return (myChildren.size() >= numChildren);
	}

	@Override
	public void addChild(NodeObject child) {
		myChildren.add(child);
	}

	@Override
	public boolean canAdd() {
//		System.out.println("can add? " + (myChildren.size() < numChildren));
		return (myChildren.size() < numChildren);
	}
	
	@Override
	public double traverseAndExecute(ControlInterface controller) {
		commandLibrary = controller.getCommandLibrary();
		Command action = commandLibrary.getCommand(myName);
		System.out.println(action);
		return action.doCommand(myChildren, controller);

	}

}
