package christmas.constant;

public enum MenuConstant {
    WHITE_MUSHROOM_SOUP("양송이수프", 6000, MenuTypeConstant.APPETIZER),
    TAPAS("타파스", 5500, MenuTypeConstant.APPETIZER),
    CAESAR_SALAD("시저샐러드", 8000, MenuTypeConstant.APPETIZER),
    T_BONE_STEAK("티본스테이크", 55000, MenuTypeConstant.MAIN),
    BBQ_RIB("바비큐립", 54000, MenuTypeConstant.MAIN),
    SEAFOOD_PASTA("해산물파스타", 35000, MenuTypeConstant.MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, MenuTypeConstant.MAIN),
    CHOCOLATE_CAKE("초코케이크", 15000, MenuTypeConstant.DESSERT),
    ICE_CREAM("아이스크림", 5000, MenuTypeConstant.DESSERT),
    ZERO_COKE("제로콜라", 3000, MenuTypeConstant.DRINK),
    RED_WINE("레드와인", 15000, MenuTypeConstant.DRINK),
    CHAMPAGNE("샴페인", 25000, MenuTypeConstant.DRINK);

    private final String name;
    private final int price;
    private final MenuTypeConstant menuTypeConstant;

    MenuConstant(String name, int price, MenuTypeConstant menuTypeConstant) {
        this.name = name;
        this.price = price;
        this.menuTypeConstant = menuTypeConstant;
    }
}
