package christmas_2.validation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class DateValidatorTest {

    @ParameterizedTest(name = "{0}년 {1}월 {2}일은 옳은 날짜다.")
    @CsvSource({
            "2023, 12, 25",
            "2020, 2, 29",
            "2021, 1, 31",
            "2021, 01, 01"
    })
    void 달력에_있는_옳은_날짜_검증_통과(final String year, final String month, final String date) {
        //When
        DateValidator.validateExistInCalendar(year, month, date);
    }

    @ParameterizedTest(name = "{0}년 {1}월 {2}일은 옳은 날짜가 아니다.")
    @CsvSource({
            "2023, 12, 0",
            "2023, 12, 32",
            "2023, 2, 30",
            "2021, 4, 31",
            "2020, 11, 31",
            "20000222222222, 1, 1"
    })
    void 달력에_없는_날짜는_예외처리(final String year, final String month, final String date) {
        assertThatThrownBy(() -> DateValidator.validateExistInCalendar(year, month, date))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
