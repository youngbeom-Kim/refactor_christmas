package christmas_2.domain.event;

import christmas_2.domain.entity.Money;
import christmas_2.domain.menu.Menu;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.EnumSet;
import java.util.stream.Stream;

import static christmas_2.domain.event.Event.CHRISTMAS_DAY_DISCOUNT;
import static christmas_2.domain.event.Event.GIFT_EVENT;
import static christmas_2.domain.event.Event.SPECIAL_DISCOUNT;
import static christmas_2.domain.event.Event.WEEKDAY_DISCOUNT;
import static christmas_2.domain.event.Event.WEEKEND_DISCOUNT;
import static christmas_2.domain.menu.Menu.DESSERTS;
import static christmas_2.domain.menu.Menu.MAIN_DISHES;
import static org.assertj.core.api.Assertions.assertThat;

public class EventTest {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void 모든_해당되는_이벤트_찾기(final LocalDate date,
                               final Menu menu,
                               final Money totalOrderPrice,
                               final EnumSet<Event> expectedEvents,
                               final int discountAmount) {
        //When
        final Benefits calculateBenefits = Event.findBenefits(date, menu, totalOrderPrice);
        final Money calculatedTotalDiscount = calculateBenefits.calcTotalDiscount();

        //Then
        assertThat(calculateBenefits.findAllEvents())
                .containsExactlyInAnyOrderElementsOf(expectedEvents);
        assertThat(calculatedTotalDiscount.getAmount()).isEqualTo(discountAmount);
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                // 10000원 미만은 혜택 없음
                Arguments.of(LocalDate.of(2023, 12, 1),
                        MAIN_DISHES,
                        Money.create(9999),
                        EnumSet.noneOf(Event.class),
                        0),

                // 크리스마스 디데이 할인 테스트 케이스
                Arguments.of(LocalDate.of(2023, 12, 21),
                        MAIN_DISHES,
                        Money.create(50000),
                        EnumSet.of(CHRISTMAS_DAY_DISCOUNT),
                        3000),

                // 평일 할인 테스트 케이스 (12월 27일은 수요일)
                Arguments.of(LocalDate.of(2023, 12, 27),
                        DESSERTS,
                        Money.create(10000),
                        EnumSet.of(WEEKDAY_DISCOUNT),
                        2023),

                // 주말 할인 테스트 케이스 (12월 30일은 토요일)
                Arguments.of(LocalDate.of(2023, 12, 30),
                        MAIN_DISHES,
                        Money.create(10000),
                        EnumSet.of(WEEKEND_DISCOUNT),
                        2023),

                // 특별 할인 테스트 케이스
                Arguments.of(LocalDate.of(2023, 12, 31),
                        MAIN_DISHES,
                        Money.create(50000),
                        EnumSet.of(SPECIAL_DISCOUNT),
                        1000),

                // 증정 이벤트 테스트 케이스 (총주문 금액 120,000원 이상)
                Arguments.of(LocalDate.of(2023, 12, 28),
                        MAIN_DISHES,
                        Money.create(120_000),
                        EnumSet.of(GIFT_EVENT),
                        25_000),

                // 이벤트 날짜가 아님
                Arguments.of(LocalDate.of(2023, 11, 30),
                        MAIN_DISHES,
                        Money.create(50000),
                        EnumSet.noneOf(Event.class),
                        0),

                // 통합 테스트
                Arguments.of(LocalDate.of(2023, 12, 1),
                        MAIN_DISHES,
                        Money.create(50000),
                        EnumSet.of(CHRISTMAS_DAY_DISCOUNT,
                                WEEKEND_DISCOUNT),
                        1000+2023),

                Arguments.of(LocalDate.of(2023, 12, 4),
                        DESSERTS,
                        Money.create(120_000),
                        EnumSet.of(CHRISTMAS_DAY_DISCOUNT,
                                WEEKDAY_DISCOUNT,
                                GIFT_EVENT),
                        1300+2023+25000),

                Arguments.of(LocalDate.of(2023, 12, 25),
                        DESSERTS,
                        Money.create(220_000),
                        EnumSet.of(CHRISTMAS_DAY_DISCOUNT,
                                WEEKDAY_DISCOUNT,
                                SPECIAL_DISCOUNT,
                                GIFT_EVENT),
                        3400+2023+1000+25000)
        );
    }
}
