package microunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Class for running unit tests without support for expected exceptions.
 */
public class BasicTestRunner extends TestRunner {

    /**
     * Creates a {@code BasicTestRunner} object for executing the test methods
     * of the class specified.
     *
     * @param testClass the class whose test methods will be executed
     */
    public BasicTestRunner(Class<?> testClass) {
        super(testClass);
    }

    @Override
    public void runTestMethods() {
        try {
            int numberOfTests = 0, numberOfFailures = 0, numberOfErrors = 0;
            for (Method method : getAnnotatedMethods(Test.class)) {
                System.out.println(method);
                Object instance = testClass.getDeclaredConstructor().newInstance();
                try {
                    method.invoke(instance);
                } catch (InvocationTargetException e) {
                    Throwable cause = e.getCause();
                    cause.printStackTrace(System.out);
                    if (cause instanceof AssertionError) {
                        numberOfFailures++;
                    } else {
                        numberOfErrors++;
                    }
                }
                numberOfTests++;
            }
            System.out.printf("Tests run: %d\n", numberOfTests);
            System.out.printf("Failures: %d\n", numberOfFailures);
            System.out.printf("Errors: %d\n", numberOfErrors);
        } catch (ReflectiveOperationException e) {
            throw new InvalidTestClassException(e);
        }
    }

    // CHECKSTYLE:OFF
    public static void main(String[] args) throws Exception {
        Class<?> testClass = Class.forName(args[0]);
        new BasicTestRunner(testClass).runTestMethods();
    }

}
