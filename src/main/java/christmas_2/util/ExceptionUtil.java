package christmas_2.util;

public class ExceptionUtil {

    public static void throwInvalidValueException() {

        throw new IllegalArgumentException();
    }

    public static void throwInvalidValueException(final String message) {

        throw new IllegalArgumentException(message);
    }

}
