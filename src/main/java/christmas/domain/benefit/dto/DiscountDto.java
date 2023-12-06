package christmas.domain.benefit.dto;

import christmas.domain.constant.Event;

public record DiscountDto(Event event, int discountPrice) {
}
