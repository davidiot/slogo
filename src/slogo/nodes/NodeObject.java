package slogo.nodes;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import slogo.interpreter.EngineController;

public abstract class NodeObject {
	protected NodeObject myParent;
	protected List<NodeObject> myChildren;
	protected Map<String, Double> localVariables;
	protected String myName;
	protected String myRawString;
	protected String myTreeStringRepresentation;
	
	public NodeObject(String name, String rawString, NodeObject parent) {
		myChildren = new LinkedList<NodeObject>();
		myParent = parent;
		localVariables = new HashMap<>();
		myName = name;
		myRawString = rawString;
	}
	
	public abstract boolean hasCompleteChildren();
	
	public List<NodeObject> getAllChildren() {
		return myChildren;
	}

	public abstract void addChild(NodeObject node);

	public abstract boolean canAdd();

	public abstract double traverseAndExecute(EngineController controller);

	public NodeObject getParent() {
		return myParent;
	}
	
	public void setLocalVariables(Map<String, Double> variables) {
		localVariables.putAll(variables);
	}
	
	public void setLocalVariable(String variable, double value) {
		localVariables.put(variable, value);
	}
	
	public Double getLocalVariable(String name) {
		return localVariables.get(name);
	}

	public String getName() {
		return myName;
	}
	
	public String getRawString(){
		return myRawString;
	}
	
	private String convertTreeToString(NodeObject root){
		if (root == null){
			return "";
		}
		String treeString = root.getRawString();
		for (NodeObject child: root.getAllChildren()){
			treeString += " ";
			treeString += convertTreeToString(child);
		}
		return treeString;
	}
	
	public String getTreeStringRepresentation(){
		return convertTreeToString(this);
	}

}
