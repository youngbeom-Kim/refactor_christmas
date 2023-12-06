package christmas.domain.benefit;

import christmas.domain.constant.Event;
import christmas.domain.order.Reservation;

import static christmas.constant.BenefitConstant.SPECIAL_DISCOUNT_PRICE;

public class SpecialDiscountBuilder extends DiscountBuilder {

    public SpecialDiscountBuilder(Reservation reservation) {
        super(Event.SPECIAL_EVENT, reservation);
    }

    protected boolean isAvailableDate() {
        return reservation.isSunday() || reservation.isChristmas();
    }

    protected int getDiscount() {
        return SPECIAL_DISCOUNT_PRICE.getValue();
    }
}
