package christmas_2.message;

public enum ErrorMessages {

    INVALID_DATE_INPUT_RE_ENTER("유효하지 않은 날짜입니다. 다시 입력해주세요."),
    INVALID_ORDER_INPUT_RE_ENTER("유효하지 않은 주문입니다. 다시 입력해주세요."),
    INVALID_ITEMS_MAP("타당하지 않은 상품이 있습니다."),
    INVALID_ITEM_COUNT("타당하지 않은 상품 개수입니다."),
    INVALID_NEGATIVE_VALUE("음수값은 사용할 수 없습니다."),
    INVALID_DIVISION_BY_ZERO("0으로 나눌 수 없습니다."),
    NOT_EXIST_MENU("존재하지 않는 메뉴입니다.");

    private final String message;
    private static final String prefix = "[ERROR] ";

    ErrorMessages(final String message) {
        this.message = prefix + message;
    }

    public String getMessage() {
        return message;
    }
}
