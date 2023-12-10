package christmas_2.domain.event;

import christmas_2.domain.entity.Money;
import christmas_2.domain.menu.Items;
import christmas_2.domain.menu.Menu;
import org.assertj.core.util.TriFunction;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.function.Predicate;

import static christmas_2.domain.event.Event.ApplyStatus.NO;

public enum Event {
    CHRISTMAS_DAY_DISCOUNT("크리스마스 디데이 할인",
            (date, items, totalOrderMoney)
                    -> ChristmasDayDiscountEvent.calculateBenefit(date)),
    WEEKDAY_DISCOUNT("평일 할인",
            (date, items, totalOrderMoney)
                    -> WeekdayDiscountEvent.calculateBenefit(date, items)),
    WEEKEND_DISCOUNT("주말 할인",
            (date, items, totalOrderPrice) ->
                    WeekendDiscountEvent.calculateBenefit(date, items)),
    SPECIAL_DISCOUNT("특별 할인",
            (date, items, totalOrderPrice) ->
                    SpecialDiscountEvent.calculateBenefit(date)),
    GIFT_EVENT("증정 이벤트",
            (date, items, totalOrderPrice) ->
                    GiftEvent.calculateBenefit(date, totalOrderPrice));

    private final String description;
    private final TriFunction<LocalDate, Items, Money, Benefit> discountCalculator;

    Event(final String description,
          final TriFunction<LocalDate, Items, Money, Benefit> discountCalculator) {
        this.description = description;
        this.discountCalculator = discountCalculator;
    }

    public Benefit calculateDiscount(final LocalDate date,
                                     final Items items,
                                     final Money totalOrderPrice) {
        return discountCalculator.apply(date, items, totalOrderPrice);
    }

    public static Benefits findBenefits(final LocalDate date,
                                        final Items items,
                                        final Money totalOrderPrice) {
        if (!isEventApplicable(totalOrderPrice)) {
            return Benefits.createEmpty();
        }
        return generateEventBenefits(date, items, totalOrderPrice);
    }

    private static boolean isEventApplicable(Money totalOrderPrice) {
        return ApplyStatus.checkEventApplication(totalOrderPrice) != NO;
    }

    private static Benefits generateEventBenefits(LocalDate date, Items items, Money totalOrderPrice) {
        EnumMap<Event, Benefit> eventBenefitsMap = new EnumMap<>(Event.class);

        for (Event event : Event.values()) {
            Benefit benefit = event.calculateDiscount(date, items, totalOrderPrice);
            if (!benefit.isNull()) {
                eventBenefitsMap.put(event, benefit);
            }
        }

        return Benefits.create(eventBenefitsMap);
    }

    public String getDescription() {
        return description;
    }

    protected enum ApplyStatus {
        YES(amount -> amount.isBiggerOrSameThan(10000)),
        NO(amount -> amount.isSmallerThan(10000));

        private final Predicate<Money> checker;

        ApplyStatus(final Predicate<Money> checker) {
            this.checker = checker;
        }

        public static ApplyStatus checkEventApplication(final Money amount) {
            return Arrays.stream(ApplyStatus.values())
                    .filter(e -> e.checker.test(amount))
                    .findFirst()
                    .orElse(NO);
        }
    }

}
