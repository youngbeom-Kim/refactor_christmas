package christmas.domain.benefit;

import christmas.domain.constant.Menus;
import christmas.domain.order.Menu;

import java.util.List;

import static christmas.constant.BenefitConstant.MIN_GIFT_PRICE;

public class ChampagneGiftGenerator implements GiftGenerator {

    private int totalPayment;

    public ChampagneGiftGenerator(int totalPayment) {
        this.totalPayment = totalPayment;
    }

    public List<Menu> generateGift() {
        if (totalPayment < MIN_GIFT_PRICE.getValue()) {
            return List.of();
        }

        return List.of(new Gift(Menus.CHAMPAGNE, 1));
    }
}
