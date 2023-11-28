package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import static christmas.constant.InfoMessage.ASKING_DATE_MESSAGE;

public class InputView {

    public int readDate() {
        System.out.println(ASKING_DATE_MESSAGE.getMessage());
        String input = Console.readLine();

        return Integer.parseInt(input);
    }

}
