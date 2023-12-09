package christmas_2.validation;

import christmas_2.util.ExceptionUtil;

import java.util.Map;

public final class MapValidator {

    public static void validateDuplicateKey(final Map map, final Object item) {
        if (map.containsKey(item)) {
            ExceptionUtil.throwInvalidValueException();
        }
    }

    public static void validateNotEmpty(final Map map) {
        if (map.size() == 0) {
            ExceptionUtil.throwInvalidValueException();
        }
    }
}
