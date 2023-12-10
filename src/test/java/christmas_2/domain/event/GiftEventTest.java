package christmas_2.domain.event;

import christmas_2.domain.entity.Money;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GiftEventTest {
    @ParameterizedTest
    @CsvSource({
            "2023-12-10, 120000, 1, 25000", // 이벤트 기간 내, 최소 주문 금액 충족
            "2023-12-26, 120000, 1, 25000", // 이벤트 기간 내, 최소 주문 금액 충족
            "2023-12-10, 119999, 0, 0", // 이벤트 기간 내, 최소 주문 금액 미충족
            "2024-01-26, 120000, 0, 0", // 이벤트 기간 이후, 최소 주문 금액 충족
            "2023-11-30, 120000, 0, 0"  // 이벤트 기간 이전, 최소 주문 금액 충족
    })
    void 증정_이벤트_계산(final String date,
                   final int totalOrderPrice,
                   final int expectedResult,
                   final int expectedDiscountPrice) {
        //Given
        final LocalDate testDate = LocalDate.parse(date);
        final Money orderPrice = Money.create(totalOrderPrice);

        //When
        final Benefit benefit = GiftEvent.calculateBenefit(testDate, orderPrice);
        final Gifts gifts = benefit.getGifts();
        final Money money = benefit.getDiscountPrice();

        //Then
        assertThat(gifts.size()).isEqualTo(expectedResult);
        assertThat(money.getAmount()).isEqualTo(expectedDiscountPrice);
    }
}
