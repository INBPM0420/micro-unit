package microunit;

/**
 * Thrown when a unit test class does not conform to the requirements, e.g.,
 * it does not have a public no-argument constructor.
 */
public class InvalidTestClassException extends RuntimeException {

    public InvalidTestClassException(String message) {
        super(message);
    }

    public InvalidTestClassException(Throwable cause) {
        super(cause);
    }

    public InvalidTestClassException(String message, Throwable cause) {
        super(message, cause);
    }

}
