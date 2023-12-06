package christmas.constant;

public enum InfoMessage {
    GREETING_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    ASKING_DATE_MESSAGE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    ASKING_MENU_MESSAGE("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    EVENT_BENEFIT_PREVIEW_MESSAGE("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n"),
    ORDERED_MENU_MESSAGE("\n<주문 메뉴>"),
    TOTAL_PRICE_BEFORE_DISCOUNT_MESSAGE("\n<할인 전 총주문 금액>"),
    GIFT_MESSAGE("\n<증정 메뉴>"),
    EVENT_BENEFIT_MESSAGE("\n<혜택 내역>"),
    EVENT_BENEFIT_TOTAL_PRICE_MESSAGE("\n<총혜택 금액>"),
    TOTAL_PRICE_AFTER_DISCOUNT_MESSAGE("\n<할인 후 예상 결제 금액>"),
    EVENT_BADGE_MESSAGE("\n<12월 이벤트 배지>"),
    MENU_EXPRESSION("%s %d개\n"),
    PRICE_EXPRESSION("%,d원\n"),
    BENEFIT_EXPRESSION("%s: %,d원\n"),
    NOTHING_MESSAGE("없음");

    private final String message;

    InfoMessage (String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
