package christmas_2.domain.menu;

import christmas_2.domain.entity.Money;

public interface Item {

    String getName();
    Money getPrice();

    default boolean hasItem(String name) {
        return getName().equalsIgnoreCase(name);
    }
}
