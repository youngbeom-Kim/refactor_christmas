package christmas.constant;

public enum BenefitConstant {
    NO_DISCOUNT(0),
    MIN_PAYMENT_PRICE(10000);

    private final int value;

    BenefitConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
