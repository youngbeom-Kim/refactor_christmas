package christmas.domain.order;

import java.util.Collections;
import java.util.List;

public class OrderMenu {

    private final List<Menu> orderMenu;

    public OrderMenu(List<Menu> orderMenu) {
        this.orderMenu = orderMenu;
    }

    public List<Menu> getOrderMenu() {
        return Collections.unmodifiableList(orderMenu);
    }
}
