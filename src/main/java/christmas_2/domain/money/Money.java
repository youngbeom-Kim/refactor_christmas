package christmas_2.domain.money;

import christmas_2.util.ExceptionUtil;
import christmas_2.validation.IntegerValidator;

import static christmas_2.message.ErrorMessages.INVALID_DIVISION_BY_ZERO;

public abstract class Money<T extends Money<T>> {

    private final int amount;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    protected abstract T create(final int amount);

    public int getAmount() {
        return amount;
    }

    public boolean isBiggerOrSameThan(final int amount) {
        return this.amount >= amount;
    }

    public boolean isSmallerThan(final int amount) {
        return this.amount <= amount;
    }

    public boolean isBiggerOrSameThan(final Money<?> other) {
        return this.amount >= other.amount;
    }

    public boolean isSmallerThan(final Money<?> other) {
        return this.amount <= other.amount;
    }

    public boolean isInRange(final Money minPrice, final Money maxPrice) {
        return isBiggerOrSameThan(minPrice) && isSmallerThan(maxPrice);
    }

    public T add(final Money<?> other) {
        return create(this.amount + other.amount);
    }

    public T subtract(final Money<?> other) {
        return create(this.amount + other.amount);
    }

    public T divide(final Money<?> other) {
        if (other.amount == 0) {
            ExceptionUtil.throwInvalidValueException(INVALID_DIVISION_BY_ZERO.getMessage());
        }
        return create(this.amount / other.amount);
    }

    public T calculateRemainder(final Money<?> other) {
        if (other.amount == 0) {
            ExceptionUtil.throwInvalidValueException(INVALID_DIVISION_BY_ZERO.getMessage());
        }
        return create(this.amount % other.amount);
    }

    protected void validate(int amount) {
        IntegerValidator.validateNotNegative(amount);
    }
}
