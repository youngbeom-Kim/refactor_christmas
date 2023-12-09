package christmas_2.domain.menu;

public enum Menu {
    APPETIZERS("에피타이저", Appetizer.values()),
    MAIN_DISHES("메인", MainDish.values()),
    DESSERT("디저트", Dessert.values()),
    DRINKS("음료", Drink.values());

    private final String description;
    private final Item[] items;

    Menu(final String description, final Item[] items) {
        this.description = description;
        this.items = items;
    }

    public String getDescription() {
        return description;
    }

    public Item[] getItems() {
        return items;
    }
}
