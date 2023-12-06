package christmas.domain.constant;

public enum Event {
    CHRISTMAS_D_DAY_EVENT("크리스마스 디데이 할인"),
    WEEKDAY_EVENT("평일 할인"),
    WEEKEND_EVENT("주말 할인"),
    SPECIAL_EVENT("특별 할인"),
    GIFT_EVENT("증정 할인");

    private final String eventName;

    Event(String eventName) {
        this.eventName = eventName;
    }

    public String getEvent() {
        return eventName;
    }
}
