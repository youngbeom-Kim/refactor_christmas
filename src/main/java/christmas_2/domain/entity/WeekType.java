package christmas_2.domain.entity;

import java.time.DayOfWeek;
import java.util.EnumSet;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;

public enum WeekType {
    WEEKDAY(EnumSet.of(SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY)),
    WEEKEND(EnumSet.of(FRIDAY, SATURDAY));

    private final EnumSet<DayOfWeek> days;

    WeekType(EnumSet<DayOfWeek> days) {
        this.days = days;
    }
}
