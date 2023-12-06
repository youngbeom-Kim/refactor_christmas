package christmas.domain.benefit;

import christmas.domain.order.Menu;

import java.util.List;

import static christmas.constant.BenefitConstant.MIN_PAYMENT_PRICE;
import static christmas.constant.BenefitConstant.NO_DISCOUNT;

public class DiscountDirector {
    private final List<DiscountBuilder> discountBuilders;
    private final GiftGenerator giftGenerator;

    public DiscountDirector(List<DiscountBuilder> discountBuilders, GiftGenerator giftGenerator) {
        this.discountBuilders = discountBuilders;
        this.giftGenerator = giftGenerator;
    }

    private boolean isAvailablePayment(DiscountBuilder discountBuilder) {
        return discountBuilder.getTotalPayment() >= MIN_PAYMENT_PRICE.getValue();
    }

    private int discount(DiscountBuilder discountBuilder) {
        if (isAvailablePayment(discountBuilder)) {
            return discountBuilder.discount();
        }

        return NO_DISCOUNT.getValue();
    }

    public List<Discount> discountAll() {
        return discountBuilders.stream()
                .map(discountBuilder -> new Discount(discountBuilder.getDiscountEvent(), discount(discountBuilder)))
                .filter(Discount::hasDiscount)
                .toList();
    }

    public List<Menu> getGifts() {
        return giftGenerator.generateGift();
    }

}
