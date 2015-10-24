package slogo.interpreter;

import java.util.List;

public class NewCommandFinder {
	private List<InputObject> parsedList;
	private NewUserCommandLibrary myUserCommands;
	private int currentIndex;
	
	public NewCommandFinder(List<InputObject> in) {
		parsedList = in;
		myUserCommands = new NewUserCommandLibrary();
	}

	public NewUserCommandLibrary findCustomCommands() {
		System.out.println("finding custom commands");
		currentIndex = 0;
		InputObject toNode = new InputObject("Command", "MakeUserInstruction"); 
		for (int i = 0; i < parsedList.size(); i ++ ) {
			if (parsedList.get(i).equals(toNode)) {
				addCustomCommand(i);
			}
			//currentIndex += 1;	
		}
		return myUserCommands;
	}
	
	private void addCustomCommand(int index) {
		System.out.print("found...  ");
		index += 1;
		int paramCount = 0;
		String name = parsedList.get(index).getValue();
		if (! parsedList.get(index).getType().equals("Command")) {
			throw new InterpreterException("Expected commmand name in make command declaration, got %s", 
					parsedList.get(index).getType());
		}
		parsedList.get(index).changeType("CommandDeclaration");
		index += 1;
		if (! parsedList.get(index).getType().equals("ListStart")) {
			throw new InterpreterException("Missing [ before parameter list in function declaration, got %s", 
					parsedList.get(index).getType());
		}
		index += 1;
		while (! parsedList.get(index).getType().equals("ListEnd")) {
			paramCount += 1;
			index += 1;
		}
		myUserCommands.addCommand(name, paramCount);
	}

}
