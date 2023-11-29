package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.view.validator.InputValidator;

import static christmas.constant.InfoMessage.ASKING_DATE_MESSAGE;

public class InputView {

    InputValidator inputValidator = new InputValidator();

    public int readDate() {
        System.out.println(ASKING_DATE_MESSAGE.getMessage());
        String input = Console.readLine();

        inputValidator.dateValidator(input);

        return Integer.parseInt(input);
    }

}
