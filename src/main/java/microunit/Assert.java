package microunit;

/**
 * Provides assertion methods for writing unit tests.
 */
public class Assert {

    /**
     * Fails a test by throwing an {@link AssertionError} with the given
     * message.
     *
     * @param message the message that describes the reason of the failure
     */
    public static void fail(String message) {
        if (message == null) {
            throw new AssertionError();
        }
        throw new AssertionError(message);
    }

    /**
     * Fails a test by throwing an {@link AssertionError} with no message.
     */
    public static void fail() {
        fail(null);
    }

    /**
     * Asserts that the given condition is true. If it's not, an
     * {@link AssertionError} is thrown with the given message.
     *
     * @param condition the condition to be tested
     * @param message the failure message for the case when the condition is
     *                false
     */
    public static void assertTrue(boolean condition, String message) {
        if (! condition) {
            fail(message);
        }
    }

    /**
     * Asserts that the given condition is true. If it's not, an
     * {@link AssertionError} is thrown with no message.
     *
     * @param condition the condition to be tested
     */
    public static void assertTrue(boolean condition) {
        assertTrue(condition, null);
    }

}
