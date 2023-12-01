package christmas.constant;

public enum IntegerConstant {
    ZERO_VALUE(0),
    ONE_VALUE(1);

    private final int value;

    IntegerConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
