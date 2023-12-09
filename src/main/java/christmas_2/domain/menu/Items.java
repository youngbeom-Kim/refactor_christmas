package christmas_2.domain.menu;

import org.mockito.internal.util.StringUtil;

import java.util.HashMap;

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
}
