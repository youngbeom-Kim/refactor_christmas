package christmas.domain.benefit;

import christmas.domain.constant.Event;

public record DiscountDto(Event event, int discountPrice) {
}
