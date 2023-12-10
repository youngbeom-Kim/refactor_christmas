package christmas_2.domain.menu;

import christmas_2.domain.money.ItemPrice;

public interface Item {

    String getName();
    ItemPrice getPrice();

    default boolean hasItem(String name) {
        return getName().equalsIgnoreCase(name);
    }
}
