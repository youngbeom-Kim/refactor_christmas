package christmas.domain.benefit.mapper;

import christmas.domain.benefit.Discount;
import christmas.domain.benefit.dto.DiscountDto;

public class DiscountMapper {
    public static DiscountDto toDto(Discount discount) {
        return new DiscountDto(discount.getDiscountEvent(), discount.getDiscountPrice());
    }
}
