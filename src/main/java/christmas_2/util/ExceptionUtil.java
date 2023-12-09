package christmas_2.util;

public final class ExceptionUtil {

    public static void throwInvalidValueException() {

        throw new IllegalArgumentException();
    }

    public static void throwInvalidValueException(final String message) {

        throw new IllegalArgumentException(message);
    }

    public static IllegalArgumentException returnInvalidValueException(final String message) {

        throw  new IllegalArgumentException(message);
    }

}
