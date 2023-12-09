package christmas_2.util;

public final class IntegerUtil {
    public static boolean isInteger(final String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
