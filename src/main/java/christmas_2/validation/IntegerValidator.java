package christmas_2.validation;

import christmas_2.util.ExceptionUtil;
import christmas_2.util.IntegerUtil;

import static christmas_2.message.ErrorMessages.INVALID_NEGATIVE_VALUE_MESSAGE;

public class IntegerValidator {

    public static void validateNotNegative(int value) {
        if (IntegerUtil.isNegative(value)) {
            ExceptionUtil.throwInvalidValueException(INVALID_NEGATIVE_VALUE_MESSAGE.getMessage());
        }
    }
}
