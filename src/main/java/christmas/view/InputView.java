package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.order.dto.MenuDto;
import christmas.validator.input.InputDateValidator;
import christmas.validator.input.InputMenuValidator;

import java.util.Arrays;
import java.util.List;

import static christmas.constant.InfoMessage.ASKING_DATE_MESSAGE;
import static christmas.constant.InfoMessage.ASKING_MENU_MESSAGE;
import static christmas.constant.IntegerConstant.ONE_VALUE;
import static christmas.constant.IntegerConstant.ZERO_VALUE;
import static christmas.constant.StringConstant.COUNT_DELIMITER;
import static christmas.constant.StringConstant.DELIMITER;

public class InputView {

    InputDateValidator inputDateValidator = new InputDateValidator();
    InputMenuValidator inputMenuValidator = new InputMenuValidator();

    public int readDate() {
        System.out.println(ASKING_DATE_MESSAGE.getMessage());
        String input = Console.readLine();

        inputDateValidator.dateValidator(input);

        return Integer.parseInt(input);
    }

    public List<MenuDto> readMenu() {
        System.out.println(ASKING_MENU_MESSAGE.getMessage());
        String input = Console.readLine();

        inputMenuValidator.menuValidator(input);

        return orderMenuClassify(input);
    }

    private List<MenuDto> orderMenuClassify(String input) {
        List<String> menu = Arrays.stream(input.split(DELIMITER.getMessage())).toList();

        return menu.stream()
                .map(String::trim)
                .map(this::orderMenuDetail)
                .toList();
    }

    private MenuDto orderMenuDetail(String input) {
        List<String> menuInfo = Arrays.stream(input.split(COUNT_DELIMITER.getMessage())).toList();

        String name = menuInfo.get(ZERO_VALUE.getValue());
        String count = menuInfo.get(ONE_VALUE.getValue());

        return new MenuDto(name, Integer.parseInt(count));
    }

}
