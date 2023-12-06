package christmas.constant;

public enum BenefitConstant {
    NO_DISCOUNT(0);

    private final int value;

    BenefitConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
