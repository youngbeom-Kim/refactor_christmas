package christmas.view;

import christmas.domain.benefit.dto.DiscountDto;
import christmas.domain.constant.Badge;
import christmas.domain.constant.Event;
import christmas.domain.order.dto.MenuDto;

import java.util.List;

import static christmas.constant.InfoMessage.BENEFIT_EXPRESSION;
import static christmas.constant.InfoMessage.EVENT_BADGE_MESSAGE;
import static christmas.constant.InfoMessage.EVENT_BENEFIT_MESSAGE;
import static christmas.constant.InfoMessage.EVENT_BENEFIT_PREVIEW_MESSAGE;
import static christmas.constant.InfoMessage.EVENT_BENEFIT_TOTAL_PRICE_MESSAGE;
import static christmas.constant.InfoMessage.GIFT_MESSAGE;
import static christmas.constant.InfoMessage.GREETING_MESSAGE;
import static christmas.constant.InfoMessage.MENU_EXPRESSION;
import static christmas.constant.InfoMessage.NOTHING_MESSAGE;
import static christmas.constant.InfoMessage.ORDERED_MENU_MESSAGE;
import static christmas.constant.InfoMessage.PRICE_EXPRESSION;
import static christmas.constant.InfoMessage.TOTAL_PRICE_AFTER_DISCOUNT_MESSAGE;
import static christmas.constant.InfoMessage.TOTAL_PRICE_BEFORE_DISCOUNT_MESSAGE;

public class OutputView {

    public void printGreetingMessage() {
        System.out.println(GREETING_MESSAGE.getMessage());
    }

    public void printEventBenefitPreviewMessage(int date) {
        System.out.printf(EVENT_BENEFIT_PREVIEW_MESSAGE.getMessage(), date);
    }

    public void printMenu(MenuDto menu) {
        System.out.printf(MENU_EXPRESSION.getMessage(), menu.name(), menu.count());
    }

    public void printOrderedMenuMessage(List<MenuDto> menus) {
        System.out.println(ORDERED_MENU_MESSAGE.getMessage());
        menus.forEach(this::printMenu);
    }

    public void printTotalPriceBeforeDiscount(int totalPrice) {
        System.out.println(TOTAL_PRICE_BEFORE_DISCOUNT_MESSAGE.getMessage());
        System.out.printf(PRICE_EXPRESSION.getMessage(), totalPrice);
    }

    public void printGiftMessage(List<MenuDto> gifts) {
        System.out.println(GIFT_MESSAGE.getMessage());

        if (gifts.isEmpty()) {
            printNothingMessage();
            return;
        }

        gifts.forEach(this::printMenu);
    }

    public void printBenefitMessage(DiscountDto discount) {
        Event event = discount.event();

        System.out.printf(BENEFIT_EXPRESSION.getMessage(), event.getEvent(), discount.discountPrice());
    }

    public void printEventBenefitMessage(List<DiscountDto> discounts) {
        System.out.println(EVENT_BENEFIT_MESSAGE.getMessage());

        if (discounts.isEmpty()) {
            printNothingMessage();
            return;
        }

        discounts.forEach(this::printBenefitMessage);
    }

    public void printEventBenefitTotalPriceMessage(int totalBenefitPrice) {
        System.out.println(EVENT_BENEFIT_TOTAL_PRICE_MESSAGE.getMessage());
        System.out.printf(PRICE_EXPRESSION.getMessage(), totalBenefitPrice);
    }

    public void printTotalPriceAfterDiscount(int totalPrice) {
        System.out.println(TOTAL_PRICE_AFTER_DISCOUNT_MESSAGE.getMessage());
        System.out.printf(PRICE_EXPRESSION.getMessage(), totalPrice);
    }

    public void printEventBadgeMessage(Badge badge) {
        System.out.println(EVENT_BADGE_MESSAGE.getMessage());

        if (badge == Badge.NO_BADGE) {
            printNothingMessage();
            return;
        }

        System.out.println(badge.getBadge());
    }

    public void printNothingMessage() {
        System.out.println(NOTHING_MESSAGE.getMessage());
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

}
