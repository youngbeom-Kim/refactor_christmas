package christmas_2.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringListUtilTest {

    @ParameterizedTest(name = "{0}을 {1}로 구분하면 {2}개로 나누어진다.")
    @CsvSource({
            "'해산물파스타,레드와인,초코케이크', ',', 3",
            "'해산물파스타;레드와인;초코케이크', ';', 3",
            "'해산물 파스타 - 레드와인 - 초코케이크', '-', 3",
            "'해산물 파스타 --- 레드와인 - 초코케이크', '-', 5",
            "'', ',', 1"
    })
    public void 주어진_seperator로_문자열_분리(final String input, final String separator, final int expectedSize) {
        //When
        List<String> result = StringListUtil.seperateBy(input, separator);

        //Then
        assertThat(result).hasSize(expectedSize);
    }
}
