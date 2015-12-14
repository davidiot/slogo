package slogo.parameters;

import slogo.interpreter.EngineController;

public class Parameterized {
	// parameters are available to all
	protected static GlobalParameters parameters;
	
	public GlobalParameters getGlobalParameters(){
		return parameters;
	}
}
