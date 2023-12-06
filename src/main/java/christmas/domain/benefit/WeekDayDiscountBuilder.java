package christmas.domain.benefit;

import christmas.domain.constant.Event;
import christmas.domain.order.Reservation;

import static christmas.constant.BenefitConstant.MENU_DISCOUNT_PRICE;

public class WeekDayDiscountBuilder extends DiscountBuilder {

    public WeekDayDiscountBuilder(Reservation reservation) {
        super(Event.WEEKDAY_EVENT, reservation);
    }

    protected boolean isAvailableDate() {
        return reservation.isWeekDay();
    }

    protected int getDiscount() {
        return reservation.getDessertMenuCount() * MENU_DISCOUNT_PRICE.getValue();
    }
}
