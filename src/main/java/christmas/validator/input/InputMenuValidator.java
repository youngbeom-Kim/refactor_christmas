package christmas.validator.input;

import christmas.exception.IllegalArgumentExceptionType;

public class InputMenuValidator {

    public void menuValidator(String input) {
        menuInputValidator(input);
    }

    private void menuInputValidator(String input) {

        if (!input.matches("^([가-힣]+-[1-9]+[0-9]*\\s*)+(,\\s*[가-힣]+-[1-9]+[0-9]*)*$")) {
            throw IllegalArgumentExceptionType.INVALID_ORDER.getException();
        }

    }

}
