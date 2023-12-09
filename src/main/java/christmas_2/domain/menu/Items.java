package christmas_2.domain.menu;

import christmas_2.util.ExceptionUtil;
import christmas_2.util.StringListUtil;
import christmas_2.util.StringUtil;
import christmas_2.validation.IntegerValidator;
import christmas_2.validation.MapValidator;

import java.util.HashMap;
import java.util.List;

import static christmas_2.constants.IntegerConstants.MAX_MENU_ITEM_COUNT;
import static christmas_2.constants.StringConstants.SEPERATE_STANDARD;

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

    private static HashMap<Item, ItemCount> toMap(final String input) {
        final HashMap<Item, ItemCount> items = new HashMap<>();

        for (final String itemNameAndCount : toList(input)) {
            final String[] parts = itemNameAndCount.split("-");
            IntegerValidator.validateNotSame(parts.length, 2);

            final Item item = Menu.findItem(parts[0]);
            final ItemCount itemCount = ItemCount.create(parts[1]);

            MapValidator.validateDuplicateKey(items, item);
            items.put(item, itemCount);
        }

        return items;
    }

    private static List<String> toList(final String input) {
        final List<String> itemNameAndCounts = StringListUtil.seperateBy(input, SEPERATE_STANDARD.getValue())
                .stream()
                .filter(s -> !s.isEmpty())
                .toList();

        return itemNameAndCounts;
    }

    private void validateSumOfCounts() {
        if (calcItemCounts() > MAX_MENU_ITEM_COUNT.getValue()) {
            ExceptionUtil.throwInvalidValueException();
        }
    }
}
