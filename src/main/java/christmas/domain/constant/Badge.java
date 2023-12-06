package christmas.domain.constant;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public enum Badge {
    NO_BADGE("없음", 0),
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000)

    private final String badge;
    private final int price;

    Badge(String badge, int price) {
        this.badge = badge;
        this.price = price;
    }

    public String getBadge() {
        return badge;
    }

    private static List<Badge> filterBadgesByPayment(int price) {
        return Stream.of(values()).filter(badge -> badge.price <= price).toList();
    }

    public static Badge getBadgeByBenefitPrice(int benefitPrice) {
        List<Badge> badges = filterBadgesByPayment(benefitPrice);

        return Collections.max(badges, Comparator.comparing(badge -> badge.price));
    }
}
