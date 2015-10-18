package slogo.interpreter;

public class RunCommandException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RunCommandException (String message, Object ... values) {
        super(String.format(message, values));
    }
	
}
