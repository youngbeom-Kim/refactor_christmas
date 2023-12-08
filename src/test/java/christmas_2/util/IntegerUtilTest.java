package christmas_2.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class IntegerUtilTest {

    @ParameterizedTest
    @CsvSource({
            "2000000000, true",
            "-2000000000, true",
            "0, true",
            "2200000000, false",
            "abc, false"
    })
    void testIsInteger(String input, boolean expected) {
        //When
        boolean result = IntegerUtil.isInteger(input);

        //When && Then
        assertThat(result).isEqualTo(expected);
    }

}
