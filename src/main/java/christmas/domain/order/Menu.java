package christmas.domain.order;

import christmas.domain.constant.MenuType;
import christmas.domain.constant.Menus;

public class Menu {

    private final Menus menus;
    private final int count;

    public Menu(Menus menus, int count) {
        this.menus = menus;
        this.count = count;
    }

    public Menus Menus() {
        return menus;
    }

    public int count() {
        return count;
    }

}
