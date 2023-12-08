package christmas_2.view;

import christmas_2.util.OutputUtil;

import static christmas_2.message.OutputMessages.ANNOUNCE_BEVERAGE_ONLY_NOT_ORDER;
import static christmas_2.message.OutputMessages.ANNOUNCE_MAX_MENU_COUNT;
import static christmas_2.message.OutputMessages.ANNOUNCE_MINIMUM_EVENT_APPLY_PRICE;
import static christmas_2.message.OutputMessages.WELCOME_MESSAGE;

public class ConsoleOutputView implements OutputView {

    @Override
    public void outputWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE.getMessage());
        OutputUtil.printEmptyLine();
    }

    @Override
    public void outputPrecaution() {
        System.out.println(ANNOUNCE_MINIMUM_EVENT_APPLY_PRICE.getMessage());
        System.out.println(ANNOUNCE_BEVERAGE_ONLY_NOT_ORDER.getMessage());
        System.out.println(ANNOUNCE_MAX_MENU_COUNT.getMessage());
        OutputUtil.printEmptyLine();
    }

    @Override
    public void outputMenu() {

    }
}
