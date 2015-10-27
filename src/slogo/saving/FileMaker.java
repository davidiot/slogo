package slogo.saving;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Map;

public class FileMaker {

	private ParsedWorkspace myParsedWorkspace;

	public FileMaker(ParsedWorkspace workspaceObject) {
		myParsedWorkspace = workspaceObject;
	}

	public String makeStrings(ParsedWorkspace workspaceObject) {
		String fileContent = "";
		Map<String, String> commandMap = workspaceObject.getCustomCommands();
		for (String s : commandMap.keySet()) {
			fileContent += " " + commandMap.get(s) + " ";
		}
		Map<String, Double> variableMap = workspaceObject.getVariableMap();
		for (String s : variableMap.keySet()) {
			fileContent += "make " + s + " " + variableMap.get(s);
		}
		System.out.println(fileContent);
		return fileContent;
	}

	public void writeFile(String name) {
		try (Writer writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(name), "utf-8"))) {
			writer.write(makeStrings(myParsedWorkspace));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
