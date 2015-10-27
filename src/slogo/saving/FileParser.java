package slogo.saving;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import slogo.interpreter.EngineController;
import sun.misc.IOUtils;

public class FileParser {

	private EngineController myController;
	
	public FileParser(EngineController controller) {
		myController = controller;
	}
	
	public void parseFile(String fileName){
		String fileNameWithExtension = fileName + ".txt";
		
	}

}
