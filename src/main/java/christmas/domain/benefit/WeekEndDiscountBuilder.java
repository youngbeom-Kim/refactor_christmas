package christmas.domain.benefit;

import christmas.domain.constant.Event;
import christmas.domain.order.Reservation;

import static christmas.constant.BenefitConstant.MENU_DISCOUNT_PRICE;

public class WeekEndDiscountBuilder extends DiscountBuilder {

    public WeekEndDiscountBuilder(Reservation reservation) {
        super(Event.WEEKEND_EVENT, reservation);
    }

    protected boolean isAvailableDate() {
        return reservation.isWeekEnd();
    }

    protected int getDiscount() {
        return reservation.getMainMenuCount() * MENU_DISCOUNT_PRICE.getValue();
    }
}
