package christmas.domain.order;

import christmas.domain.constant.MenuType;
import christmas.domain.constant.Menus;

public abstract class Menu {

    private final Menus menus;
    private final int count;

    public Menu(Menus menus, int count) {
        this.menus = menus;
        this.count = count;
    }

    public Menus getMenus() {
        return menus;
    }

    public int count() {
        return count;
    }

    public int getCount() {
        return count;
    }

    public int getTotalPrice() {
        return menus.getPrice() * count;
    }

    public boolean isDessert() {
        return menus.menuType() == MenuType.DESSERT;
    }

    public boolean isMain() {
        return menus.menuType() == MenuType.MAIN;
    }

    public boolean isDrink() {
        return menus.menuType() == MenuType.DRINK;
    }

}
