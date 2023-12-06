package christmas.domain.benefit;

import christmas.domain.constant.Event;
import christmas.domain.order.Reservation;

import static christmas.constant.BenefitConstant.ADDITIONAL_DISCOUNT_PRICE;
import static christmas.constant.BenefitConstant.BASE_DISCOUNT_PRICE;
import static christmas.constant.DateConstant.CHRISTMAS_DATE;

public class ChristmasDiscountBuilder extends DiscountBuilder {

    public ChristmasDiscountBuilder(Reservation reservation) {
        super(Event.CHRISTMAS_D_DAY_EVENT, reservation);
    }

    protected boolean isAvailableDate() {
        return reservation.getVisitDayOfMonth() == CHRISTMAS_DATE.getValue();
    }

    protected int getDiscount() {
        return BASE_DISCOUNT_PRICE.getValue()
                + (reservation.getVisitDayOfMonth() * ADDITIONAL_DISCOUNT_PRICE.getValue());
    }

}
