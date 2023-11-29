package christmas.view.validator;

import christmas.exception.IllegalArgumentExceptionType;

public class InputValidator {

    public void dateValidator(String input) {
        onlyNumberValidator(input);
    }

    public void onlyNumberValidator(String input) {

        if (!input.matches("[0-9]+")) {
            throw IllegalArgumentExceptionType.INVALID_DATE.getException();
        }

    }

}
