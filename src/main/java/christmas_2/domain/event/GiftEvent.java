package christmas_2.domain.event;

import christmas_2.domain.entity.Money;
import christmas_2.domain.menu.Item;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static christmas_2.constants.IntegerConstants.THIS_MONTH;
import static christmas_2.constants.IntegerConstants.THIS_YEAR;
import static christmas_2.domain.menu.Drink.Champagne;

public enum GiftEvent {
    GIFT_EVENT_CONDITIONS(120_000, 1, 31);

    private Money minimumMoney;
    private LocalDate startDate;
    private LocalDate endDate;

    GiftEvent(final int minimumMoney, final int startDate, final int endDate) {
        this.minimumMoney = Money.create(minimumMoney);
        this.startDate = LocalDate.of(THIS_YEAR.getValue(), THIS_MONTH.getValue(), startDate);
        this.endDate = LocalDate.of(THIS_YEAR.getValue(), THIS_MONTH.getValue(), endDate);
    }

    public static Benefit calculateBenefit(final LocalDate date, final Money totalOrderPrice) {
        if (!isMeetingConditions(date, totalOrderPrice)) {
            return Benefit.createEmpty();
        }
        return Benefit.create(createGifts());
    }

    private static boolean isMeetingConditions(final LocalDate date, final Money totalOrderPrice) {
        return totalOrderPrice.isBiggerOrSameThan(GIFT_EVENT_CONDITIONS.minimumMoney) &&
                !date.isBefore(GIFT_EVENT_CONDITIONS.startDate) &&
                !date.isAfter(GIFT_EVENT_CONDITIONS.endDate);
    }

    private static Gifts createGifts() {
        final List<Item> giftItems = Arrays.stream(GiftItem.values())
                .map(GiftItem::getItem)
                .toList();

        return Gifts.create(giftItems);
    }

    protected enum GiftItem {
        CHAMPAGNE(Champagne);

        private Item item;

        GiftItem(final Item item) {
            this.item = item;
        }

        public Item getItem() {
            return item;
        }
    }
}
