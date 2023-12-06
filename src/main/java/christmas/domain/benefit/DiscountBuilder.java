package christmas.domain.benefit;

import christmas.domain.constant.Event;
import christmas.domain.order.Reservation;

import java.util.Objects;

import static christmas.constant.BenefitConstant.NO_DISCOUNT;

public abstract class DiscountBuilder {

    private final Event event;
    protected final Reservation reservation;

    public DiscountBuilder(Event event, Reservation reservation) {
        this.event = event;
        this.reservation = reservation;
    }

    public Event getDiscountEvent() {
        return event;
    }

    public int getTotalPayment() {
        return reservation.getTotalPayment();
    }

    public int discount() {
        if (isAvailableDate()) {
            return getDiscount();
        }

        return NO_DISCOUNT.getValue();
    }

    abstract protected boolean isAvailableDate();

    abstract protected int getDiscount();

}
