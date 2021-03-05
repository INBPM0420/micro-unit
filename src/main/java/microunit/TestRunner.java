package microunit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Abstract base class for classes for running unit tests.
 */
public abstract class TestRunner {

    protected Class<?> testClass;

    /**
     * Creates a {@code TestRunner} object for executing the test methods of
     * the class specified.
     *
     * @param testClass the class whose test methods will be executed
     */
    protected TestRunner(Class<?> testClass) {
        this.testClass = testClass;
    }

    /**
     * Returns the list of methods of the class marked with the annotation
     * specified.
     *
     * @param annotationClass a {@link Class} object representing an annotation
     *                        type
     * @return the list of methods of the class marked with the annotation
     *         specified
     */
    protected List<Method> getAnnotatedMethods(Class<? extends Annotation> annotationClass) {
        return Arrays.stream(testClass.getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(annotationClass))
                .collect(Collectors.toList());
    }

    /**
     * Runs the test methods of the class.
     */
    public abstract void runTestMethods();

}
