package christmas_2.view;

import christmas_2.util.InputUtil;

import static christmas_2.message.InputMessages.INPUT_EXPECTED_DATE_OF_VISIT;
import static christmas_2.message.InputMessages.ORDER_MENU_ITEM_WITH_COUNT;

public class ConsoleInputView implements InputView {
    @Override
    public String inputExpectedDateOfVisit() {
        System.out.println(INPUT_EXPECTED_DATE_OF_VISIT.getMessage());
        return InputUtil.inputString();
    }

    @Override
    public String inputOrderItemsWithCounts() {
        System.out.println(ORDER_MENU_ITEM_WITH_COUNT.getMessage());
        return InputUtil.inputString();
    }
}
