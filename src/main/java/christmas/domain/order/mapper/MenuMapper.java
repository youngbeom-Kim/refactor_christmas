package christmas.domain.order.mapper;

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

    private static Menus convertMenuName(String menuName) {
        try {
            return Menus.getByMenuName(menuName);
        } catch (IllegalArgumentException e) {
            throw IllegalArgumentExceptionType.INVALID_ORDER.getException();
        }
    }
}
