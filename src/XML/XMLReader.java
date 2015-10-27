package XML;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import slogo.character.MainCharacter;
import slogo.parameters.GlobalParameters;

/**
to set, save, and load workspace preferences (like default background, starting 
image list, starting number of turtles, starting file to load, command 
language, etc.)
 **/


public class XMLReader {
	private String fileName;
	private String simulation;
	private List<MainCharacter> characters;
	private List<String> commands;
	private final static String SIMNAME = "simulation";
	private final static String TAGNAME = "Characters";
	private final static String NUMPARAM = "numberparameters";
	private final static String COLPARAM = "colorparameters";
	private final static String NAME = "name";
	private final static String VALUE = "value";
	private final static int ZERO = 0;
	private Map<String, Double> numParameters;
	private Map<String, String> colParameters;
	private int width;
	private int height;

	public XMLReader(String file) {
		fileName = file;
		numParameters = new HashMap<String, Double>();
		colParameters = new HashMap<String, String>();
	}

	/**
	 *Background color, line color, dash, animation speed, number turtles
	 */
	public void readFile() {
		try {
			File fXmlFile = new File(fileName);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			initNumParameters(doc);
			initColorParameters(doc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//number values such as dash, animation speed, and number of turtles
	public void initNumParameters (Document doc) {
		NodeList nList = doc.getElementsByTagName(NUMPARAM);
		Node nNode = nList.item(ZERO);
		for (int temp = ZERO; temp < nList.getLength(); temp++) {
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				nNode = nList.item(temp);
				Element eElement = (Element) nNode;
				String name = eElement.getElementsByTagName(NAME).item(ZERO)
						.getTextContent();
				Double val = Double.parseDouble(eElement
						.getElementsByTagName(VALUE).item(ZERO)
						.getTextContent());
				numParameters.put(name, val);
			}
		}
	}

	//Color values such as background color and line color
	public void initColorParameters (Document doc) {
		NodeList nList = doc.getElementsByTagName(COLPARAM);
		Node nNode = nList.item(ZERO);
		for (int temp = ZERO; temp < nList.getLength(); temp++) {
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				nNode = nList.item(temp);
				Element eElement = (Element) nNode;
				String name = eElement.getElementsByTagName(NAME).item(ZERO)
						.getTextContent();
				String val = eElement
						.getElementsByTagName(VALUE).item(ZERO)
						.getTextContent();
				colParameters.put(name, val);
			}
		}
	}
	
	public GlobalParameters setGlobalParameters(){
		GlobalParameters globals = new GlobalParameters();
		globals.setValue("Speed", numParameters.get("Speed"));
		globals.setValue("Line Thickness", numParameters.get("Line Thickness"));
		globals.setValue("Dash Level", numParameters.get("Dash Level"));
		globals.setBackgroundColorHex(colParameters.get("Background"));
		return globals;
	}

	public Map<String, Double> getNumParams() {
		return numParameters;
	}
	
	public Map<String, String> getColorParams() {
		return colParameters;
	}
}
