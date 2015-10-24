package slogo.interpreter;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class Parser {
	private List<Entry<String, Pattern>> defaults;
	private List<Entry<String, Pattern>> patterns;
	private String myLanguage;
	private static final String COMMAND = "Command";
	
	public Parser(String language) {
		myLanguage = language;
	}
	
	public List<InputObject> parse(String input) {
		defaults = new ArrayList<>();
		patterns = new ArrayList<>();
		String location = String.format("resources/languages/%s", myLanguage);
		defaults.addAll(makePatterns(location));
		patterns.addAll(makePatterns("resources/languages/syntax"));
		List<InputObject> parsed = convert(removeComments(input));
		return parsed;
	}
	
	
	private List<String> removeComments(String input) {
		String[] lines = input.split("\n");
		List<String> splitInputs = new ArrayList<>();
		for (String line: lines) {
			if (! line.startsWith("#")) {
				List<String> split = Arrays.asList(line.split("\\s+"));
				for (String entry: split) {
					if (entry.trim().length() > 0) {
						splitInputs.add(entry.trim());
					}
				}
				
			}
		}
//		System.out.println("removed " + indInputs);
		return splitInputs;
	}
	

	private List<InputObject> convert (List<String> list)  {
    	List<InputObject> converted = new ArrayList<>();
        for (String s : list) {
            boolean matched = false;
            String type = "";
            String name = "";
            if (s.trim().length() > 0) {
                for (Entry<String, Pattern> p : patterns) {
                    if (match(s, p.getValue())) {
                    	type = p.getKey();
                        if (p.getKey().equals(COMMAND)){
                        	// translate any default commands in different langauge into
                        	// their default form (e.g. "avanzar" becomes "Forward")
                        	// if a command is not default it stays the same form
                        	name = translate(s);
                        } else {
                        	name = s;
                        }
                        matched = true;
                        break;
                    }
                }
                if (! matched) {
                	throw new InterpreterException("%s not matched to input type", s);
                }
            }
            converted.add(new InputObject(type, name));
        }
		return converted;
    }

	private String translate(String s) {
		for (Entry<String, Pattern> p : defaults) {
            if (match(s, p.getValue())) {
                return p.getKey();
            }
		}
		return s;
	}
	
	/**
	 * From example_regex in class repository
	 */
    public List<Entry<String, Pattern>> makePatterns (String syntax) {
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
    
	/**
	 * From example_regex in class repository
	 */
	
	public boolean match (String input, Pattern regex) {
        return regex.matcher(input).matches();
    }


}
