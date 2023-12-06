package christmas.domain.order;

import christmas.domain.constant.Menus;

import java.util.Collections;
import java.util.List;

public class OrderMenu {

    private final List<Menu> orderMenu;

    public OrderMenu(List<Menu> orderMenu) {
        this.orderMenu = orderMenu;
    }

    public List<Menu> getOrderMenu() {
        return Collections.unmodifiableList(orderMenu);
    }

    public int getDessertMenuCount() {
        return orderMenu.stream()
                .filter(Menu::isDessert)
                .mapToInt(Menu::getCount)
                .sum();
    }

    public int getMainMenuCount() {
        return orderMenu.stream()
                .filter(Menu::isMain)
                .mapToInt(Menu::getCount)
                .sum();
    }

    public int getTotalPayment() {
        return orderMenu.stream().mapToInt(Menu::getTotalPrice).sum();
    }
}
