package christmas_2.validation;

import christmas_2.util.ExceptionUtil;
import christmas_2.util.IntegerUtil;

import java.math.BigInteger;

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

    public static void validateInRange(final int value, final int min, final int max) {
        validateNotSmaller(value, min);
        validateNotBigger(value, max);
    }

    public static void validateNotSmaller(final int value, final int min) {
        if (value < min) {
            ExceptionUtil.throwInvalidValueException();
        }
    }

    public static void validateNotBigger(final int value, final int max) {
        if (value > max) {
            ExceptionUtil.throwInvalidValueException();
        }
    }

    public static void validatePlusRange(final int value1, final int value2) {
        final BigInteger a = BigInteger.valueOf(value1);
        final BigInteger b = BigInteger.valueOf(value2);
        final BigInteger result = a.add(b);

        if (result.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0 ||
                result.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
            ExceptionUtil.throwInvalidValueException();
        }
    }
}
