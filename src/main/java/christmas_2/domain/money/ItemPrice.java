package christmas_2.domain.money;

public class ItemPrice extends Money {

    public ItemPrice(int amount) {
        super(amount);
    }
    @Override
    protected Money create(int amount) {
        return new ItemPrice(amount);
    }
}
