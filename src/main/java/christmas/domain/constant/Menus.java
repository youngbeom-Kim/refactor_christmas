package christmas.domain.constant;

import christmas.domain.order.Menu;
import christmas.exception.IllegalArgumentExceptionType;

import java.util.stream.Stream;

public enum Menus {
    WHITE_MUSHROOM_SOUP("양송이수프", 6000, MenuType.APPETIZER),
    TAPAS("타파스", 5500, MenuType.APPETIZER),
    CAESAR_SALAD("시저샐러드", 8000, MenuType.APPETIZER),
    T_BONE_STEAK("티본스테이크", 55000, MenuType.MAIN),
    BBQ_RIB("바비큐립", 54000, MenuType.MAIN),
    SEAFOOD_PASTA("해산물파스타", 35000, MenuType.MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, MenuType.MAIN),
    CHOCOLATE_CAKE("초코케이크", 15000, MenuType.DESSERT),
    ICE_CREAM("아이스크림", 5000, MenuType.DESSERT),
    ZERO_COKE("제로콜라", 3000, MenuType.DRINK),
    RED_WINE("레드와인", 15000, MenuType.DRINK),
    CHAMPAGNE("샴페인", 25000, MenuType.DRINK);

    private final String name;
    private final int price;
    private final MenuType menuType;

    Menus(String name, int price, MenuType menuType) {
        this.name = name;
        this.price = price;
        this.menuType = menuType;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public MenuType menuType() {
        return menuType;
    }

    public static Menus getByMenuName(String name) {
        return Stream.of(values())
                .filter(menus -> name.equals(menus.name))
                .findAny()
                .orElseThrow(IllegalArgumentExceptionType.INVALID_ORDER::getException);
    }

}
