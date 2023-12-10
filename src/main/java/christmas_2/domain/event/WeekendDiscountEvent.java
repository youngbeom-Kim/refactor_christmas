package christmas_2.domain.event;

import christmas_2.domain.entity.Money;
import christmas_2.domain.entity.WeekType;
import christmas_2.domain.menu.Menu;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static christmas_2.constants.IntegerConstants.THIS_MONTH;
import static christmas_2.constants.IntegerConstants.THIS_YEAR;
import static christmas_2.domain.entity.WeekType.WEEKEND;
import static christmas_2.domain.menu.Menu.MAIN_DISHES;

public enum WeekendDiscountEvent {
    DISCOUNT_CONDITIONS(WEEKEND, MAIN_DISHES, 1, 31);

    private final WeekType validWeekType;
    private final Menu validMenu;
    private LocalDate startDate;
    private LocalDate endDate;

    WeekendDiscountEvent(final WeekType validWeekType, final Menu validMenu, final int startDate, final int endDate) {
        this.validWeekType = validWeekType;
        this.validMenu = validMenu;
        this.startDate = LocalDate.of(THIS_YEAR.getValue(), THIS_MONTH.getValue(), startDate);
        this.endDate = LocalDate.of(THIS_YEAR.getValue(), THIS_MONTH.getValue(), endDate);
    }

    public static Benefit calculateBenefit(final LocalDate date, final Menu menu) {
        if (isApplicable(date, menu)) {
            return Benefit.create(calcDiscountPrice());
        }
        return Benefit.createEmpty();
    }

    private static boolean isApplicable(final LocalDate date, final Menu menu) {
        return isDateInValidWeekType(date) &&
                DISCOUNT_CONDITIONS.validMenu == menu &&
                !date.isBefore(DISCOUNT_CONDITIONS.startDate) &&
                !date.isAfter(DISCOUNT_CONDITIONS.endDate);
    }

    private static boolean isDateInValidWeekType(final LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        WeekType currentWeekType = DISCOUNT_CONDITIONS.validWeekType;

        return currentWeekType.contains(dayOfWeek);
    }

    private static Money calcDiscountPrice() {
        return DiscountAmount.STANDARD.amount;
    }

    protected enum DiscountAmount {
        STANDARD(2023);

        private final Money amount;

        DiscountAmount(int amount) {
            this.amount = Money.create(amount);
        }

    }
}
