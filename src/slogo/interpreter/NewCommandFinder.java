package slogo.interpreter;

import java.util.List;

public class NewCommandFinder {
	private List<InputObject> parsedList;
	private TemporaryCommandLibrary myUserCommands;
	
	public NewCommandFinder(List<InputObject> in) {
		parsedList = in;
		myUserCommands = new TemporaryCommandLibrary();
	}

	public TemporaryCommandLibrary findCustomCommands() {
		System.out.println("finding custom commands");
		int currentIndex = 0;
		InputObject toNode = new InputObject("Command", "MakeUserInstruction"); 
		for (InputObject in: parsedList) {
			if (in.equals(toNode)) addCustomCommand(currentIndex);
		}
		return myUserCommands;
	}
	
	
	
	private void addCustomCommand(int index) {
		System.out.print("found...  ");
		int currentIndex = index + 1;
		int paramCount = 0;
		String name = parsedList.get(currentIndex).getValue();
		System.out.println("name: " + name);
		parsedList.get(currentIndex).changeType("CommandDeclaration");
		currentIndex += 1;
		if (! parsedList.get(currentIndex).getType().equals("ListStart")) {
			// TODO maybe throw error
			System.out.println("missing open bracket");
		}
		currentIndex += 1;
		// TODO check for out of bounds
		while (! parsedList.get(currentIndex).getType().equals("ListEnd")) {
			paramCount += 1;
			currentIndex += 1;
		}
		myUserCommands.addCommand(name, paramCount);
	}

}
