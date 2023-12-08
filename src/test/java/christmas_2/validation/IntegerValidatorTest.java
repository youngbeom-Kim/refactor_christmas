package christmas_2.validation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @ParameterizedTest
    @CsvSource({
        "0, 1, 100",
        "101, 1, 100",
        "100, 101, 1"
    })
    public void 범위_밖의_값이면_예외_발생(final int value, final int min, final int max) {
        assertThatThrownBy(() -> IntegerValidator.validateInRange(value, min, max))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0, 1",
            "1, 1, 100",
            "2, 1, 3"
    })
    public void 범위_내의_값이면_정상_통과(final int value, final int min, final int max) {
        IntegerValidator.validateInRange(value, min, max);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "-1, 1"
    })
    public void 최소값보다_작으면_예외_발생(final int value, final int min) {
        assertThatThrownBy(() -> IntegerValidator.validateNotSmaller(value, min))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "-1, -5"
    })
    public void 최소값보다_작지않으면_통과(final int value, final int min) {
        IntegerValidator.validateNotSmaller(value, min);
    }

    @ParameterizedTest
    @CsvSource({
            "3, 1",
            "-1, -5"
    })
    public void 최대값보다_크면_예외_발생(final int value, final int max) {
        assertThatThrownBy(() -> IntegerValidator.validateNotBigger(value, max))
                   .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "-1, 5"
    })
    public void 최대값보다_크지않으면_통과(final int value, final int max) {
        IntegerValidator.validateNotBigger(value, max);
    }

    @ParameterizedTest
    @CsvSource({
            "2147483647, 1",
            "-2147483648, -1"
    })
    public void 덧셈_범위_초과시_예외_발생(final int value1, final int value2) {
        assertThatThrownBy(() -> IntegerValidator.validatePlusRange(value1, value2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 2",
            "2147483645, 1",
            "-2147483645, -1"
    })
    public void 덧셈_범위_초과아닐시_정상_통과(final int value1, final int value2) {
        IntegerValidator.validatePlusRange(value1, value2);
    }
}