package christmas_2.message;

import static christmas_2.constants.IntegerConstants.THIS_MONTH;

public enum InputMessages {

    INPUT_EXPECTED_DATE_OF_VISIT(String.format("%d월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"
            , THIS_MONTH.getValue())),

    ORDER_MENU_ITEM_WITH_COUNT("주문하실 메뉴를 메뉴와 개수를 알려 주세요, (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");

    private final String message;

    InputMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
