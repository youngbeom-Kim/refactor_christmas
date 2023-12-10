package christmas_2.domain.event;

import christmas_2.domain.entity.Money;

import java.time.LocalDate;

import static christmas_2.constants.IntegerConstants.THIS_MONTH;
import static christmas_2.constants.IntegerConstants.THIS_YEAR;
import static christmas_2.domain.event.ChristmasDayDiscountEvent.DiscountAmount.DAILY_SURCHARGE;
import static christmas_2.domain.event.ChristmasDayDiscountEvent.DiscountAmount.STANDARD;
import static java.time.temporal.ChronoUnit.DAYS;

public enum ChristmasDayDiscountEvent {
    CHRISTMAS_DAY_DISCOUNT_CONDITIONS(1, 25);

    private final LocalDate startDate;
    private final LocalDate endDate;

    ChristmasDayDiscountEvent(final int startDate, final int endDate) {
        this.startDate = LocalDate.of(THIS_YEAR.getValue(), THIS_MONTH.getValue(), startDate);
        this.endDate = LocalDate.of(THIS_YEAR.getValue(), THIS_MONTH.getValue(), endDate);
    }

    public static Benefit calculateBenefit(final LocalDate date) {
        if (!isMeetingConditions(date)) {
            return Benefit.createEmpty();
        }
        return Benefit.create(calcDiscountPrice(date));
    }

    private static boolean isMeetingConditions(final LocalDate date) {
        return !(date.isBefore(CHRISTMAS_DAY_DISCOUNT_CONDITIONS.startDate)
                || date.isAfter(CHRISTMAS_DAY_DISCOUNT_CONDITIONS.endDate));
    }

    private static Money calcDiscountPrice(final LocalDate date) {
        final Money dailySurcharge = calculateDailySurcharge(date);
        return dailySurcharge.add(STANDARD.amount);
    }

    private static Money calculateDailySurcharge(final LocalDate date) {
        final int daysSinceStart = (int) DAYS.between(CHRISTMAS_DAY_DISCOUNT_CONDITIONS.startDate, date);
        final Money oneDaySurcharge = DAILY_SURCHARGE.amount;
        return oneDaySurcharge.multiply(daysSinceStart);
    }

    enum DiscountAmount {

        STANDARD(1000),
        DAILY_SURCHARGE(100);

        private final Money amount;

        DiscountAmount(final int amount) {
            this.amount = Money.create(amount);
        }

    }
}
