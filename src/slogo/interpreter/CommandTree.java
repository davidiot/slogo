package slogo.interpreter;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.regex.Pattern;


public class CommandTree {
	private Node root;
	private String myLanguage;
	private ActionLibrary myActions;
	private VariableLibrary myVariables;


	public CommandTree(String language, ActionLibrary actions, VariableLibrary variables) {
		root = new Node(null);	// root has no action
		myLanguage = language;
		myActions = actions;
		myVariables = variables;	
	}

	public void build(String input) {
        List<Entry<String, Pattern>> patterns = new ArrayList<>();
        String location = String.format("resources/languages/%s", myLanguage);
        //String location = "resources/languages/English";
        patterns.addAll(makePatterns(location));
}

// Probably don't need this
//	private boolean treeComplete() {
//		return root.hasCompleteChildren();
//	}

	public void run() {
		root.execute();
	}
	
	/**
	 * From example_regex in class repository
	 */
    public static List<Entry<String, Pattern>> makePatterns (String syntax) {
        ResourceBundle resources = ResourceBundle.getBundle(syntax);
        List<Entry<String, Pattern>> patterns = new ArrayList<>();
        Enumeration<String> iter = resources.getKeys();
        while (iter.hasMoreElements()) {
            String key = iter.nextElement();
            String regex = resources.getString(key);
            patterns.add(new SimpleEntry<String, Pattern>(key,
                         // THIS IS THE KEY LINE
                         Pattern.compile(regex, Pattern.CASE_INSENSITIVE)));
        }
        return patterns;
    }
	
	
	public static boolean match (String input, Pattern regex) {
        return regex.matcher(input).matches();
    }
	

}
