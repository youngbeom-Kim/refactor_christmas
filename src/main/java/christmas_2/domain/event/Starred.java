package christmas_2.domain.event;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static christmas_2.constants.IntegerConstants.THIS_MONTH;
import static christmas_2.constants.IntegerConstants.THIS_YEAR;

public enum Starred {
    YES(Set.of(3, 10, 17, 24, 31, 25)),
    NO(Set.of());

    private final Set<LocalDate> dates;

    Starred(final Set<Integer> days) {
        this.dates = toLocalDate(days);
    }

    public static boolean isStarred(final LocalDate date) {
        return YES.isContaining(date);
    }

    public static Starred findStarred(final LocalDate date) {
        return Stream.of(Starred.values())
                .filter(starred -> starred.isContaining(date))
                .findFirst()
                .orElse(NO);
    }

    private Set<LocalDate> toLocalDate(final Set<Integer> days) {
        return days.stream()
                .map(day -> LocalDate.of(THIS_YEAR.getValue(), THIS_MONTH.getValue(), day))
                .collect(Collectors.toSet());
    }

    public boolean isContaining(final LocalDate date) {
        return dates.contains(date);
    }
}
