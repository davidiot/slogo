package slogo.interpreter;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class SyntaxTranslator {
	private List<Entry<String, Pattern>> defaults;
	private List<Entry<String, Pattern>> patterns;
	private String myLanguage;
	private static final String COMMAND = "Command";
	
	public SyntaxTranslator(String language) {
		myLanguage = language;
	}
	
	public List<String> parse(String input) {
		defaults = new ArrayList<>();
		patterns = new ArrayList<>();
		String location = String.format("resources/languages/%s", myLanguage);
		//String location = "resources/languages/English";
		defaults.addAll(makePatterns(location));
		patterns.addAll(makePatterns("resources/languages/syntax"));
		String[] splitInput = input.split("\\s+");
		List<String> converted = convert(splitInput);
		return converted;
	}
	
	
    private List<String> convert (String[] input) {
    	ArrayList<String> checked = new ArrayList<String>();
        for (String s : input) {
            boolean matched = false;
            if (s.trim().length() > 0) {
                for (Entry<String, Pattern> p : patterns) {
                    if (match(s, p.getValue())) {
//                        System.out.println(String.format("%s matches %s", s, p.getKey()));
                        if (p.getKey().equals(COMMAND)){
                        	// translate any default commands in different langauge into
                        	// their default form (e.g. "avanzar" becomes "Forward")
                        	// if a command is not default it stays the same form
                        	checked.add(translate(s));
                        } else {
                        	checked.add(s);
                        }
                        matched = true;
                        break;
                    }
                }
                if (! matched) {
                	// TODO throw syntax error
//                    System.out.println(String.format("%s not matched", s));
                }
            }
        }
        System.out.println(checked);
		return checked;
    }

	private String translate(String s) {
		for (Entry<String, Pattern> p : defaults) {
            if (match(s, p.getValue())) {
//                System.out.println(String.format("%s matches %s", s, p.getKey()));
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
        System.out.println(patterns);
        return patterns;
    }
    
	/**
	 * From example_regex in class repository
	 */
	
	public boolean match (String input, Pattern regex) {
        return regex.matcher(input).matches();
    }

}
