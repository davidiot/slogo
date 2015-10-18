package slogo.nodes;

import slogo.character.CharacterInterface;

public class RootNode extends NodeObject {

	public RootNode(NodeObject parent) {
		super(null, parent);
	}

	@Override
	public boolean hasCompleteChildren() {
		return true;
	}

	@Override
	public void addChild(NodeObject node) {
		myChildren.add(node);
	}

	@Override
	public boolean canAdd() {
		return true;
	}

	@Override
	public double traverseAndExecute(CharacterInterface character) {
		for (NodeObject child: myChildren){
			child.traverseAndExecute(character);
		}
		return 0;
	}

}
