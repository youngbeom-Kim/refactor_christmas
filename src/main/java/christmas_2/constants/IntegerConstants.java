package christmas_2.constants;

public enum IntegerConstants {
    THIS_MONTH(12),
    THIS_YEAR(2023),
    MINIMUM_EVENT_APPLY_PRICE(10000),
    MAX_MENU_ITEM_COUNT(20),
    MIN_VISIT_DATE_RANGE(1),
    MAX_VISIT_DATE_RANGE(31),
    MIN_ORDER_ITEM_COUNT(1);

    private final int value;

    IntegerConstants(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return String.valueOf(value);
    }
}
