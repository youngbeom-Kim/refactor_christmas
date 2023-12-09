package christmas_2.view;

import christmas_2.domain.menu.Item;
import christmas_2.domain.menu.Menu;
import christmas_2.util.OutputUtil;

import static christmas_2.message.StartMessages.ANNOUNCE_BEVERAGE_ONLY_NOT_ORDER;
import static christmas_2.message.StartMessages.ANNOUNCE_MAX_MENU_COUNT;
import static christmas_2.message.StartMessages.ANNOUNCE_MINIMUM_EVENT_APPLY_PRICE;
import static christmas_2.message.StartMessages.WELCOME;

public class ConsoleStartView implements StartView {

    @Override
    public void printWelcomeMessage() {
        System.out.println(WELCOME.getMessage());
        OutputUtil.printEmptyLine();
    }

    @Override
    public void printPrecaution() {
        System.out.println(ANNOUNCE_MINIMUM_EVENT_APPLY_PRICE.getMessage());
        System.out.println(ANNOUNCE_BEVERAGE_ONLY_NOT_ORDER.getMessage());
        System.out.println(ANNOUNCE_MAX_MENU_COUNT.getMessage());
        OutputUtil.printEmptyLine();
    }

    @Override
    public void printMenu() {
        for (Menu menu : Menu.values()) {
            System.out.println("<" + menu.getDescription() + ">");
            for (Item item : menu.getItems()) {
                System.out.println(item.getName() + "(" + item.getPrice() + ")");
            }
            OutputUtil.printEmptyLine();
        }
        OutputUtil.printEmptyLine();
    }
}
