package christmas_2.validation;

import christmas_2.util.ExceptionUtil;
import christmas_2.util.IntegerUtil;

public class IntegerValidator {

    public static void validateInteger(final String string) {
        if (!IntegerUtil.isInteger(string)) {
            ExceptionUtil.throwInvalidValueException();
        }
    }

    public static void validateNotNegative(final int value) {
        if (value < 0) {
            ExceptionUtil.throwInvalidValueException();
        }
    }
}
