package slogo.interpreter;

public class SyntaxException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SyntaxException (String message, Object ... values) {
        super(String.format(message, values));
    }
}
