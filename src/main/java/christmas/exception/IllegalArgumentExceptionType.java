package christmas.exception;

public enum IllegalArgumentExceptionType implements ExceptionType<IllegalArgumentException> {

    INVALID_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String message;

    IllegalArgumentExceptionType(String message) {
        this.message = errorPrefix + message;
    }

    public String getMessage() {
        return message;
    }

    public IllegalArgumentException getException() {
        return new IllegalArgumentException(message);
    }

}