package slogo.nodes;

import slogo.character.CharacterInterface;
import slogo.character.MainCharacter;
import slogo.interpreter.EngineController;

public class RootNode extends NodeObject {

	public RootNode(NodeObject parent) {
		super(parent);
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
	public double traverseAndExecute(EngineController controller) {
		for (NodeObject child: myChildren){
			child.traverseAndExecute(controller);
		}
		return 0;
	}

}
