package christmas.domain.benefit;

import christmas.domain.constant.Event;

import static christmas.constant.BenefitConstant.NO_DISCOUNT;

public class Discount {

    private final Event event;
    private final int discountPrice;

    public Discount(Event event, int discountPrice) {
        this.event = event;
        this.discountPrice = discountPrice;
    }

    public Event getDiscountEvent() {
        return event;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public boolean hasDiscount() {
        return discountPrice != NO_DISCOUNT.getValue();
    }

}
