package christmas.domain.order;

import christmas.domain.constant.MenuType;

public class Menu {

    private final MenuType menuType;
    private final int count;

    public Menu(MenuType menuType, int count) {
        this.menuType = menuType;
        this.count = count;
    }

    public MenuType MenuType() {
        return menuType;
    }

    public int count() {
        return count;
    }

}
