package christmas_2.view;

import christmas_2.domain.dto.MemberBadgeDto;
import christmas_2.domain.dto.OrderBenefitsDto;
import christmas_2.domain.dto.OrderItemsDto;
import christmas_2.message.ErrorMessages;
import christmas_2.util.OutputUtil;
import christmas_2.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

import static christmas_2.message.OutputMessages.BENEFITS_TITLE;
import static christmas_2.message.OutputMessages.GIFT_MENU_TITLE;
import static christmas_2.message.OutputMessages.ORDER_MENU_TITLE;
import static christmas_2.message.OutputMessages.PREVIEW_TITLE;
import static christmas_2.message.OutputMessages.THIS_MONTH_EVENT_BADGE_TITLE;
import static christmas_2.message.OutputMessages.TOTAL_BENEFITS_PRICE_TITLE;
import static christmas_2.message.OutputMessages.TOTAL_PRICE_AFTER_DISCOUNT_TITLE;
import static christmas_2.message.OutputMessages.TOTAL_PRICE_BEFORE_DISCOUNT_TITLE;

public class ConsoleOutputView implements OutputView {
    @Override
    public void outputPreviewTitle() {
        outputTitle(PREVIEW_TITLE.getMessage());

        OutputUtil.printEmptyLine();
    }

    @Override
    public void outputOrderItems(final OrderItemsDto orderItemsDto) {
        outputItemAndCounts(orderItemsDto.getItems());
        outputTotalPriceBeforeDiscount(orderItemsDto.getPriceBeforeDiscount());
    }

    private void outputTotalPriceBeforeDiscount(int priceBeforeDiscount) {
    }

    @Override
    public void outputBenefits(final OrderBenefitsDto orderBenefitsDto) {
        final Map<String, Integer> gifts = orderBenefitsDto.getGifts();
        final Map<String, Integer> discounts = orderBenefitsDto.getDiscounts();
        final int totalPriceBeforeDiscount = orderBenefitsDto.getPriceBeforeDiscount();
        final int sumDiscounts = sumDiscounts(discounts);
        final int totalPriceAfterDiscount = totalPriceBeforeDiscount - sumDiscounts;

        outputGifts(gifts);
        outputDiscounts(discounts);
        outputTotalPriceAfterDiscount(totalPriceAfterDiscount);
    }

    @Override
    public void outputThisMonthBadge(MemberBadgeDto memberBadgeDto) {
        outputTitle(TOTAL_PRICE_BEFORE_DISCOUNT_TITLE.getMessage());

        final String badge = memberBadgeDto.getBadge();
        System.out.println(badge);
    }

    private void outputItemAndCounts(final Map<String, Integer> itemsAndCounts) {
        outputTitle(ORDER_MENU_TITLE.getMessage());

        for (Map.Entry<String, Integer> entry : itemsAndCounts.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue() + "개");
        }
        OutputUtil.printEmptyLine();
    }

    private int sumDiscounts(final Map<String, Integer> discounts) {
        return discounts.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private void outputGifts(final Map<String, Integer> gifts) {
        outputTitle(GIFT_MENU_TITLE.getMessage());

        for (Map.Entry<String, Integer> entry : gifts.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue() + "개");
        }
        OutputUtil.printEmptyLine();
    }

    private void outputDiscounts(final Map<String, Integer> discounts) {
        outputTitle(BENEFITS_TITLE.getMessage());

        for (Map.Entry<String, Integer> discountEntry : discounts.entrySet()) {
            System.out.println(discountEntry.getKey() + ": "
                    + StringUtil.formatByThousandSeparator(discountEntry.getValue() * -1)
                    + "원");
        }
        OutputUtil.printEmptyLine();
    }

    public void outputTotalPriceAfterDiscount(final int totalPriceAfterDiscount) {
        outputTitle(TOTAL_PRICE_AFTER_DISCOUNT_TITLE.getMessage());
        System.out.println(StringUtil.formatByThousandSeparator(totalPriceAfterDiscount));
        OutputUtil.printEmptyLine();
    }

    private void outputTitle(String title) {
        System.out.println("<" + title + ">");
    }
}
