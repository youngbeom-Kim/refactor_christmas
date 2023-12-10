package christmas_2.domain.dto;

import christmas_2.domain.event.Event;
import christmas_2.domain.menu.Item;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class DtoMapper {

    private DtoMapper() {

    }

    public static MemberBadgeDto toMemberBadgeDto(final String badge) {
        return new MemberBadgeDto(badge);
    }

    public static OrderItemsDto toOrderItemsDto(final Map<String, Integer> items,
                                                final int priceBeforeDiscount) {
        return new OrderItemsDto(items, priceBeforeDiscount);
    }

    public static OrderBenefitsDto toOrderBenefitsDto(final Map<String, Integer> gifts,
                                                      final Map<String, Integer> discounts,
                                                      final int priceBeforeDiscount) {
        return new OrderBenefitsDto(gifts, discounts, priceBeforeDiscount);
    }
}
