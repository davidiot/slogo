package slogo.nodes;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import slogo.character.MainCharacter;

public abstract class NodeObject {
	protected NodeObject myParent;
	protected List<NodeObject> myChildren;
	protected Map<String, Double> localVariables;
	
	public NodeObject(NodeObject parent) {
		myChildren = new LinkedList<NodeObject>();
		myParent = parent;
		localVariables = new HashMap<>();
	}
	
	public abstract boolean hasCompleteChildren();
	
	public List<NodeObject> getAllChildren() {
		return myChildren;
	}

	public abstract void addChild(NodeObject node);

	public abstract boolean canAdd();

	public abstract double traverseAndExecute(MainCharacter character);

	public NodeObject getParent() {
		return myParent;
	}

}
