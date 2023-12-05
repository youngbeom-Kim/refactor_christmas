package christmas.validator.input;

import christmas.exception.IllegalArgumentExceptionType;

import static christmas.constant.DateConstant.DATE_MAX_NUMBER;
import static christmas.constant.DateConstant.DATE_MIN_NUMBER;

public class InputDateValidator {

    public void dateValidator(String input) {
        onlyNumberValidator(input);
        dateRangeValidator(input);
    }

    private void onlyNumberValidator(String input) {

        if (!input.matches("[0-9]+")) {
            throw IllegalArgumentExceptionType.INVALID_DATE.getException();
        }

    }

    private void dateRangeValidator(String input) {

        int date = Integer.parseInt(input);

        if (date < DATE_MIN_NUMBER.getValue() || date > DATE_MAX_NUMBER.getValue()) {
            throw IllegalArgumentExceptionType.INVALID_DATE.getException();
        }

    }

}
