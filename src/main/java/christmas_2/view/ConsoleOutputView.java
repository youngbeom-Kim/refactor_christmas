package christmas_2.view;

import christmas_2.message.ErrorMessages;
import christmas_2.util.OutputUtil;

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
        System.out.println(makeTitleForm(PREVIEW_TITLE.getMessage()));

        OutputUtil.printEmptyLine();
    }

    @Override
    public void outputOrderMenu() {
        System.out.println(makeTitleForm(ORDER_MENU_TITLE.getMessage()));

        OutputUtil.printEmptyLine();
    }

    @Override
    public void outputTotalPriceBeforeDiscount() {
        System.out.println(makeTitleForm(TOTAL_PRICE_BEFORE_DISCOUNT_TITLE.getMessage()));

        OutputUtil.printEmptyLine();
    }

    @Override
    public void outputGiftMenu() {
        System.out.println(makeTitleForm(GIFT_MENU_TITLE.getMessage()));

        OutputUtil.printEmptyLine();
    }

    @Override
    public void outputBenefits() {
        System.out.println(makeTitleForm(BENEFITS_TITLE.getMessage()));

        OutputUtil.printEmptyLine();
    }

    @Override
    public void outputTotalBenefitsPrice() {
        System.out.println(makeTitleForm(TOTAL_BENEFITS_PRICE_TITLE.getMessage()));

        OutputUtil.printEmptyLine();
    }

    @Override
    public void outputTotalPriceAfterDiscount() {
        System.out.println(makeTitleForm(TOTAL_PRICE_AFTER_DISCOUNT_TITLE.getMessage()));

        OutputUtil.printEmptyLine();
    }

    @Override
    public void outputThisMonthBadge() {
        System.out.println(makeTitleForm(THIS_MONTH_EVENT_BADGE_TITLE.getMessage()));
    }

    private String makeTitleForm(String title) {
        return "<" + title + ">";
    }
}
