package slogo.interpreter;

public class InterpreterException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InterpreterException (String message, Object ... values) {
        super(String.format(message, values));
    }
}
