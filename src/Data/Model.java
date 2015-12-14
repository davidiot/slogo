package Data;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import slogo.character.MainCharacter;
import slogo.parameters.GlobalParameters;

/**
 * Class solely for storing data to save to xml
 * @author danielpak
 *
 */
public class Model implements Serializable {

	private List<String> h;
	private List<String> c;
	private List<String> v;
	//private Display myDisplay; 

	public Model(){
		//myDisplay = d;
		h = new ArrayList<String>(); 
		c = new ArrayList<String>(); 
		v = new ArrayList<String>(); 
	}

	public List<String> getHistory(){
		return h;
	}
	
	public List<String> getCommands(){
		return c;
	}
	
	public List<String> getVariables(){
		return v;
	}
	
	//public GlobalParameters getParameters(){
	//return myGlobalParameters;
	//}
	
	public void setHistory(List<String> hist){
		h = hist;
	}
	
	public void setCommands(List<String> com){
		c = com;
	}
	
	public void setVariables(List<String> var){
		v = var;
	}

	
}
