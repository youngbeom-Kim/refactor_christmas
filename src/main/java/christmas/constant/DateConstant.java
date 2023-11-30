package christmas.constant;

public enum DateConstant {
    DATE_MIN_NUMBER(1),
    DATE_MAX_NUMBER(31);

    private final int value;

    DateConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
