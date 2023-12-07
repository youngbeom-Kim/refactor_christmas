package christmas_2.domain.money;

import christmas_2.validation.IntegerValidator;

public abstract class Money<T extends Money<T>> {

    private final int amount;

    public Money(int amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    protected abstract T create(final int amount);

    public int getAmount() {
        return amount;
    }

    protected void validateAmount(int amount) {
        IntegerValidator.validateNotNegative(amount);
    }
}
