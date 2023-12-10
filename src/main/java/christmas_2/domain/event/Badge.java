package christmas_2.domain.event;

import christmas_2.domain.money.DiscountPrice;
import christmas_2.domain.money.Money;
import christmas_2.util.ExceptionUtil;

import java.util.Arrays;

import static christmas_2.message.ErrorMessages.INVALID_BADGE_PRICE;

public enum Badge {

    NO("없음", 0, 4999),
    STAR("별", 5_000, 9_999),
    TREE("트리", 10_000, 19_999),
    SANTA("산타", 20_000, Integer.MAX_VALUE);

    private final String name;
    private final DiscountPrice minBenefitsPrice;
    private final DiscountPrice maxBenefitsPrice;


    Badge(final String name, final int minBenefitsPrice, final int maxBenefitsPrice) {
        this.name = name;
        this.minBenefitsPrice = new DiscountPrice(minBenefitsPrice);
        this.maxBenefitsPrice = new DiscountPrice(maxBenefitsPrice);
    }

    public static Badge getBadgeByPrice(final Money price) {
        return Arrays.stream(Badge.values())
                .filter(badge -> price.isInRange(badge.minBenefitsPrice, badge.maxBenefitsPrice))
                .findFirst()
                .orElseThrow(() -> ExceptionUtil.returnInvalidValueException(INVALID_BADGE_PRICE.getMessage()));
    }
}
