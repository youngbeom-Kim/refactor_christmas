package christmas_2.domain.dto;

import christmas_2.domain.event.Event;
import christmas_2.domain.menu.Item;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class OrderBenefitsDto {

    private final Map<String, Integer> gifts;
    private final Map<String, Integer> discounts;
    private final int priceBeforeDiscount;

    public OrderBenefitsDto(final Map<String, Integer> gifts,
                            final Map<String, Integer> discounts,
                            final int priceBeforeDiscount) {
        this.gifts = gifts;
        this.discounts = discounts;
        this.priceBeforeDiscount = priceBeforeDiscount;
    }

    public Map<String, Integer> getGifts() {
        return gifts;
    }

    public Map<String, Integer> getDiscounts() {
        return discounts;
    }

    public int getPriceBeforeDiscount() {
        return priceBeforeDiscount;
    }
}
