package christmas.validator.input;

import christmas.exception.IllegalArgumentExceptionType;

import java.util.Arrays;

import static christmas.constant.IntegerConstant.ONE_VALUE;
import static christmas.constant.IntegerConstant.ZERO_VALUE;
import static christmas.constant.MenuConstant.MENU_MAX_NUMBER;
import static christmas.constant.MenuConstant.MENU_MIN_NUMBER;

public class InputMenuValidator {

    public void menuValidator(String input) {
        menuInputValidator(input);
        menuCountValidator(input);
    }

    private void menuInputValidator(String input) {

        if (!input.matches("^([가-힣]+-[1-9]+[0-9]*\\s*)+(,\\s*[가-힣]+-[1-9]+[0-9]*)*$")) {
            throw IllegalArgumentExceptionType.INVALID_ORDER.getException();
        }

    }

    private void menuCountValidator(String input) {

        String[] menu = input.split(",");

        int count = 0;

        for (int i = ZERO_VALUE.getValue(); i < menu.length; i++) {
            count = count + Integer.parseInt(menu[i].split("-")[ONE_VALUE.getValue()]);

            if (count < MENU_MIN_NUMBER.getValue() || count > MENU_MAX_NUMBER.getValue()) {
                throw IllegalArgumentExceptionType.INVALID_ORDER.getException();
            }

        }

    }

}
