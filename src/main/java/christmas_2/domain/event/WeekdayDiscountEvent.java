package christmas_2.domain.event;

import christmas_2.domain.entity.Money;
import christmas_2.domain.entity.WeekType;
import christmas_2.domain.menu.Item;
import christmas_2.domain.menu.ItemCount;
import christmas_2.domain.menu.Items;
import christmas_2.domain.menu.Menu;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static christmas_2.constants.IntegerConstants.THIS_MONTH;
import static christmas_2.constants.IntegerConstants.THIS_YEAR;
import static christmas_2.domain.entity.WeekType.WEEKDAY;
import static christmas_2.domain.event.WeekdayDiscountEvent.DiscountAmount.STANDARD;
import static christmas_2.domain.menu.Menu.DESSERTS;

public enum WeekdayDiscountEvent {
    DISCOUNT_CONDITIONS(WEEKDAY, DESSERTS, 1, 31);

    private final WeekType validWeekType;
    private final Menu validMenu;
    private final LocalDate startDate;
    private final LocalDate endDate;

    WeekdayDiscountEvent(final WeekType validWeekType,
                         final Menu validMenu,
                         final int startDate,
                         final int endDate) {
        this.validWeekType = validWeekType;
        this.validMenu = validMenu;
        this.startDate = LocalDate.of(THIS_YEAR.getValue(), THIS_MONTH.getValue(), startDate);
        this.endDate = LocalDate.of(THIS_YEAR.getValue(), THIS_MONTH.getValue(), endDate);
    }

    public static Benefit calculateBenefit(final LocalDate date, final Items items) {
        final Money totalDiscount = items.toEntrySet()
                .stream()
                .map(entry -> {
                    final Item item = entry.getKey();
                    final ItemCount itemCount = entry.getValue();
                    final Menu menu = Menu.findMenu(item);

                    if (!isApplicable(date, menu)) {
                        return Money.create(0);
                    }
                    return calcDiscountPrice().multiply(itemCount.getCount());
                })
                .reduce(Money.create(0), Money::add);

        return Benefit.create(totalDiscount);
    }


    private static boolean isApplicable(final LocalDate date, final Menu menu) {
        return isDateInValidaWeekType(date) &&
                DISCOUNT_CONDITIONS.validMenu == menu &&
                !date.isBefore(DISCOUNT_CONDITIONS.startDate) &&
                !date.isAfter(DISCOUNT_CONDITIONS.endDate);
    }

    private static boolean isDateInValidaWeekType(final LocalDate date) {
        final DayOfWeek dayOfWeek = date.getDayOfWeek();
        final WeekType currentWeekType = DISCOUNT_CONDITIONS.validWeekType;

        return currentWeekType.contains(dayOfWeek);
    }

    private static Money calcDiscountPrice() {
        return STANDARD.amount;
    }

    protected enum DiscountAmount {
        STANDARD(2023);

        private final Money amount;

        DiscountAmount(int amount) {
            this.amount = Money.create(amount);
        }
    }
}
