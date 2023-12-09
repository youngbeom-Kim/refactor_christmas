package christmas_2.domain.menu;

public interface Item {

    String getName();
    int getPrice();

    default boolean hasItem(String name) {
        return getName().equalsIgnoreCase(name);
    }
}
