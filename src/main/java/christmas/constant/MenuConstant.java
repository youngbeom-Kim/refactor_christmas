package christmas.constant;

public enum MenuConstant {
    MENU_MIN_NUMBER(1),
    MENU_MAX_NUMBER(20);

    private final int value;

    MenuConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
