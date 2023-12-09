package christmas_2.validation;

import christmas_2.util.ExceptionUtil;

import java.time.DateTimeException;
import java.time.LocalDate;

import static christmas.exception.IllegalArgumentExceptionType.INVALID_DATE;

public class DateValidator {

    public static void validateExistInCalendar(final String year,
                                               final String month,
                                               final String date) {
        IntegerValidator.validateInteger(year, month, date);

        try {
            LocalDate.of(Integer.parseInt(year),
                    Integer.parseInt(month),
                    Integer.parseInt(date));
        } catch (DateTimeException e) {
            ExceptionUtil.throwInvalidValueException(INVALID_DATE.getMessage());
        }
    }
}
