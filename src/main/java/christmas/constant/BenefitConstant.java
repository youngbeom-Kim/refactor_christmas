package christmas.constant;

public enum BenefitConstant {
    NO_DISCOUNT(0),
    MIN_PAYMENT_PRICE(10000),
    MIN_GIFT_PRICE(120000),
    BASE_DISCOUNT_PRICE(-900),
    ADDITIONAL_DISCOUNT_PRICE(-100),
    SPECIAL_DISCOUNT_PRICE(-1000),
    MENU_DISCOUNT_PRICE(-2023);

    private final int value;

    BenefitConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
