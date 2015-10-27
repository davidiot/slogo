package XML;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import slogo.parameters.GlobalParameters;
import slogo.screen.SettingsScreen;

public class XMLEditor {
	private String fileName;
	private Map<String, Double> numParameters;
	private Map<String, String> colorParameters;
	private GlobalParameters globals;
	private final static String NUMPARAM = "numberparameters";
	private final static String COLPARAM = "colorparameters";

	public XMLEditor(String s, GlobalParameters gParams) {
		fileName = s;
		globals = gParams;
		numParameters = new HashMap<String,Double>();
		colorParameters = new HashMap<String,String>();
	}

	public Document readFile() {
		try {
			String filepath = fileName;
			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath);
			return doc;
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
			return null;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return null;
		} catch (SAXException sae) {
			sae.printStackTrace();
			return null;
		}
	}
	
	public void initGlobalParameters(){
		numParameters = globals.getValueMap();
		colorParameters.put("BackgroundColor", globals.getBackgroundColor());
	}

	public void editFile() {
		Document doc = readFile();
		Node first = doc.getFirstChild();
		initGlobalParameters();
		addNumParameters(doc, first, numParameters);
		addColorParameters(doc, first, colorParameters);
		//addCells(doc, first, cells);
		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();
		Transformer transformer;
		try {
			transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(fileName));
			transformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Done");
	}

	public void addNumParameters(Document doc, Node first,
			Map<String, Double> params) {
		removeNode(first, NUMPARAM);
		for (String s : params.keySet()) {
			Node temp = addNode(doc, first, NUMPARAM, "name", s);
			addElement(doc, temp, "value", params.get(s));
		}
	}
	
	public void addColorParameters(Document doc, Node first,
			Map<String, String> params) {
		removeNode(first, COLPARAM);
		for (String s : params.keySet()) {
			Node temp = addNode(doc, first, COLPARAM, "name", s);
			addElement(doc, temp, "value", params.get(s));
		}
	}

	/**
	public void addCells(Document doc, Node first, List<List<Cell>> cells2) {
		removeNode(first, "row");
		for (int i = 0; i < cells2.size(); i++) {
			String temp = "";
			for (int j = 0; j < cells2.get(i).size() - 1; j++) {
				temp += Integer.toString(cells2.get(j).get(i)
						.getMyCurrentState())
						+ ",";
			}
			temp += Integer.toString(cells2.get(0)
					.get(cells2.get(0).size() - 1).getMyCurrentState());
			addNode(doc, first, "row", "values", temp);

		}

	}
	**/

	public void removeNode(Node curr, String check) {
		NodeList list = curr.getChildNodes();
		for (int i = list.getLength() - 1; i > 0; i--) {
			if (list.item(i).getNodeName().equals(check)) {
				curr.removeChild(list.item(i));
			}
		}
	}

	/**
	 * Add a node to the curr Node with a new element of a given string value.
	 * 
	 * @param doc
	 * @param curr
	 * @param node
	 * @param element
	 * @param value
	 */
	public Node addNode(Document doc, Node curr, String node, String element,
			String value) {
		Node temp = doc.createElement(node);
		Element tempEl = doc.createElement(element);
		tempEl.appendChild(doc.createTextNode(value));
		temp.appendChild(tempEl);
		curr.appendChild(temp);
		return temp;
	}

	/**
	 * Add a node to the curr Node with a new element of a given double value.
	 * 
	 * @param doc
	 * @param curr
	 * @param node
	 * @param element
	 * @param value
	 * @return
	 */
	public Node addNode(Document doc, Node curr, String node, String element,
			Double value) {
		return addNode(doc, curr, node, element, Double.toString(value));
	}

	/**
	 * Add an element to the curr node with the given string value.
	 * 
	 * @param doc
	 * @param curr
	 * @param element
	 * @param value
	 */
	public void addElement(Document doc, Node curr, String element, String value) {
		Element temp = doc.createElement(element);
		temp.appendChild(doc.createTextNode(value));
		curr.appendChild(temp);
	}

	/**
	 * Add an element to the curr node with the given double value
	 * 
	 * @param doc
	 * @param curr
	 * @param element
	 * @param value
	 */
	public void addElement(Document doc, Node curr, String element, Double value) {
		addElement(doc, curr, element, Double.toString(value));
	}
}
