package christmas.domain.result;

import christmas.domain.benefit.Discount;
import christmas.domain.order.Menu;

import java.util.List;

public class EventResult {
    private final List<Discount> discounts;
    private final List<Menu> gifts;

    public EventResult(List<Discount> discounts, List<Menu> gifts) {
        this.discounts = discounts;
        this.gifts = gifts;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public List<Menu> getGifts() {
        return gifts;
    }

    public int getTotalDiscount() {
        return discounts.stream().mapToInt(Discount::getDiscountPrice).sum();
    }

    public int getTotalGiftsPrice() {
        return gifts.stream().mapToInt(Menu::getTotalPrice).sum();
    }

    public int getTotalBenefitPrice() {
        return getTotalGiftsPrice() - getTotalDiscount();
    }

    public int getTotalPriceAfterDiscount(int price) {
        return price + getTotalDiscount();
    }
}
