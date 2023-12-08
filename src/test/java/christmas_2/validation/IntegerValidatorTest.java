package christmas_2.validation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class IntegerValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"k", "2200000000"})
    public void 정수가_아니면_예외_처리(String input) {
        assertThatThrownBy(() -> IntegerValidator.validateInteger(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"20", "-20", "0", "2100000000"})
    public void 정수가_맞으면_검증_통과(String input) {
        IntegerValidator.validateInteger(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {-20, -2100000000})
    public void 음수면_예외_발생(int value) {
        assertThatThrownBy(() -> IntegerValidator.validateNotNegative(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {20, 0, 2100000000})
    public void 음수가_아니면_검증_통과(int value) {
        IntegerValidator.validateNotNegative(value);
    }
}
