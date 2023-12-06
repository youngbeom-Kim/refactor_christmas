package christmas.domain.order;

import christmas.constant.DateConstant;
import christmas.domain.constant.EventWeek;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

import static christmas.constant.DateConstant.DECEMBER;
import static christmas.constant.DateConstant.EVENT_YEAR;

public class VisitDate {

    private final LocalDate localDate;

    public VisitDate(int date) {
        this.localDate = LocalDate.of(EVENT_YEAR.getValue(), DECEMBER.getValue(), date);
    }

    public int getDayOfMonth() {
        return localDate.getDayOfMonth();
    }

    public boolean isSunday() {
        return localDate.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    public boolean isWeekDay() {
        return EventWeek.WEEKDAY.contains(localDate.getDayOfWeek());
    }

    public boolean isWeekEnd() {
        return EventWeek.WEEKEND.contains(localDate.getDayOfWeek());
    }

    public boolean isChristmas() {
        return localDate.getDayOfMonth() == DateConstant.CHRISTMAS_DATE.getValue();
    }

}
