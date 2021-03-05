package microunit;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that the annotated method is intended to be a test method.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {

    /**
     * The execution of the test method succeeds if and only if an exception of
     * this class is thrown.
     *
     * @return the class of the exception expected to be thrown
     */
    Class<? extends Throwable> expected() default None.class;

    /**
     * Represents that no exceptions are expected.
     */
    class None extends Throwable {}

}
