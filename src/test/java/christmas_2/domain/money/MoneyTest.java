package christmas_2.domain.money;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static christmas_2.message.ErrorMessages.INVALID_DIVISION_BY_ZERO;
import static christmas_2.message.ErrorMessages.INVALID_NEGATIVE_VALUE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class MoneyTest {

    private static class TestMoney extends Money {
        public TestMoney(int amount) {
            super(amount);
        }

        @Override
        protected Money create(int amount) {
            return new TestMoney(amount);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 20, 2100000000, 0})
    public void 정상_Money_자식_객체_생성(int amount) {
        //when
        Money money = new TestMoney(amount);

        //Then
        assertThat(money.getAmount()).isEqualTo(amount);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2100000000})
    public void Money_는_음수값을_가질_수_없음(int amount) {
        //When && Then
        assertThatThrownBy(() -> new TestMoney(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_NEGATIVE_VALUE.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "100, 100, true",
            "100, 50, true",
            "100, 150, false"
    })
    public void 더_크거나_같은_값인지_상태값_반환(int amount, int compareTo, boolean expected) {
        //Given
        Money money = new TestMoney(amount);

        //When && Then
        assertThat(money.isBiggerOrSameThan(compareTo)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource( {
            "100, 150, true",
            "100, 100, false",
            "100, 50, flase"
    })
    public void 더_작은_값인지_상태값_반환(int amount, int compareTo, boolean expected) {
        //Given
        Money money = new TestMoney(amount);

        //When && Then
        assertThat(money.isSmallerThan(compareTo)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "100, 50, 150",
            "0, 0, 0"
    })
    void Money_끼리_더하면_새로운_Money_객체(int amount1, int amount2, int expected) {
        //Given
        TestMoney money1 = new TestMoney(amount1);
        TestMoney money2 = new TestMoney(amount2);

        //When
        TestMoney result = (TestMoney) money1.add(money2);

        //Then
        assertThat(money1).isNotSameAs(result);
        assertThat(money2).isNotSameAs(result);
        assertThat(result.getAmount()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "100, 10, 10",
            "10, 1, 10",
            "0, 100, 0"
    })
    void Money_끼리_나누면_새로운_Money_객체(int amount1, int amount2, int expected) {
        //Given
        TestMoney money1 = new TestMoney(amount1);
        TestMoney money2 = new TestMoney(amount2);

        //When
        TestMoney result = (TestMoney) money1.divide(money2);

        //Then
        assertThat(result.getAmount()).isEqualTo(expected);
    }

    @Test
    void Money_는_0_으로_나눌_수_없음() {
        //Given
        TestMoney money1 = new TestMoney(100);
        TestMoney money2 = new TestMoney(0);

        //When && Then
        assertThatThrownBy(() -> money1.divide(money2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_DIVISION_BY_ZERO.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "100, 30, 10",
            "0, 30, 0"
    })
    void Money_끼리_나머지_계산하면_새로운_Money_객체(int amount1, int amount2, int expected) {
        //Given
        TestMoney money1 = new TestMoney(amount1);
        TestMoney money2 = new TestMoney(amount2);

        //When
        TestMoney result = (TestMoney) money1.calculateRemainder(money2);

        //Then
        assertThat(result.getAmount()).isEqualTo(expected);
    }

    @Test
    void Money_는_나머지_계산시_0으로_나눌_수_없음() {
        //Given
        TestMoney money1 = new TestMoney(100);
        TestMoney money2 = new TestMoney(0);

        //When && Then
        assertThatThrownBy(() -> money1.calculateRemainder(money2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_DIVISION_BY_ZERO.getMessage());
    }
}
