package christmas_2.domain.money;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static christmas_2.message.ErrorMessages.INVALID_NEGATIVE_VALUE_MESSAGE;
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
                .hasMessageContaining(INVALID_NEGATIVE_VALUE_MESSAGE.getMessage());
    }
}
