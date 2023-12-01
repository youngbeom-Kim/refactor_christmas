package christmas.constant;

public enum InfoMessage {
    GREETING_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    ASKING_DATE_MESSAGE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    ASKING_MENU_MESSAGE("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");

    private final String message;

    InfoMessage (String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
