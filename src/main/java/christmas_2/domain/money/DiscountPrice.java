package christmas_2.domain.money;

public class DiscountPrice extends Money{

    public DiscountPrice(final int amount) {
        super(amount);
    }

    @Override
    protected Money create(int amount) {
        return null;
    }
}
