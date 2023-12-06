package christmas.domain.order.mapper;

import christmas.domain.constant.MenuType;
import christmas.domain.constant.Menus;
import christmas.domain.order.Menu;
import christmas.domain.order.Order;
import christmas.domain.order.dto.MenuDto;
import christmas.exception.IllegalArgumentExceptionType;

public class MenuMapper {

    public static Menu toDomain(MenuDto menuDto) {
        String name = menuDto.name();
        int count = menuDto.count();
        Menus menus = convertMenuName(name);
        return new Order(menus, count);
    }

    public static MenuDto toDto(Menu orderMenu) {
        Menus menus = orderMenu.getMenus();
        String name = menus.getName();
        int count = orderMenu.getCount();

        return new MenuDto(name, count);
    }

    private static Menus convertMenuName(String menuName) {
        try {
            return Menus.getByMenuName(menuName);
        } catch (IllegalArgumentException e) {
            throw IllegalArgumentExceptionType.INVALID_ORDER.getException();
        }
    }
}
