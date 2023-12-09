package christmas_2.domain.menu;

import christmas_2.util.ExceptionUtil;
import org.mockito.internal.util.StringUtil;

import java.util.HashMap;

import static christmas_2.constants.IntegerConstants.MAX_MENU_ITEM_COUNT;

public class Items {

    private final HashMap<Item, ItemCount> items;

    private Items(final HashMap<Item, ItemCount> items) {
        this.items = items;
    }

    public static Items create(final String input) {
        final String deletedSpaces = StringUtil.removeAllSpaces(input);
        final HashMap<Item, ItemCount> items = toMap(deletedSpaces);

        return new Items(items);
    }

    public HashMap<Item, ItemCount> getItems() {
        return new HashMap<>(items);
    }

    public int calcItemCounts() {
        return items.values().stream()
                .mapToInt(ItemCount::getCount)
                .sum();
    }

    private void validateSumOfCounts() {
        if (calcItemCounts() > MAX_MENU_ITEM_COUNT.getValue()) {
            ExceptionUtil.throwInvalidValueException();
        }
    }
}
