package slogo.nodes;

import slogo.character.MainCharacter;

public class UserCommandNode extends NodeObject {
	private int numChildren;

	public UserCommandNode(NodeObject parent, int numParams) {
		super(parent);
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
	public double traverseAndExecute(MainCharacter character) {
		return 0;
	}

}
