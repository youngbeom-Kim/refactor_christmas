package christmas_2.domain.dto;

import christmas_2.domain.menu.Item;

import java.util.HashMap;

public class OrderItemsDto {

    private final HashMap<String, Integer> items;
    private final int priceBeforeDiscount;

    public OrderItemsDto(final HashMap<String, Integer> items, final int priceBeforeDiscount) {
        this.items = items;
        this.priceBeforeDiscount = priceBeforeDiscount;
    }

    public HashMap<String, Integer> getItems() {
        return items;
    }

    public int getPriceBeforeDiscount() {
        return priceBeforeDiscount;
    }
}
