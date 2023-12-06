package christmas.domain.benefit.factory;

import christmas.domain.benefit.ChristmasDiscountBuilder;
import christmas.domain.benefit.DiscountBuilder;
import christmas.domain.benefit.SpecialDiscountBuilder;
import christmas.domain.benefit.WeekDayDiscountBuilder;
import christmas.domain.benefit.WeekEndDiscountBuilder;
import christmas.domain.order.Reservation;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public enum DiscountFactory {
    CHRISTMAS(ChristmasDiscountBuilder::new),
    SPECIAL(SpecialDiscountBuilder::new),
    WEEKDAY(WeekDayDiscountBuilder::new),
    WEEKEND(WeekEndDiscountBuilder::new);

    private final Function<Reservation, DiscountBuilder> builderFunction;

    DiscountFactory(Function<Reservation, DiscountBuilder> builderFunction) {
        this.builderFunction = builderFunction;
    }

    public DiscountBuilder build(Reservation reservation) {
        return builderFunction.apply(reservation);
    }

    public static List<DiscountBuilder> buildAll(Reservation reservation) {
        return Stream.of(values())
                .map(discountFactory -> discountFactory.build(reservation))
                .toList();
    }
}
