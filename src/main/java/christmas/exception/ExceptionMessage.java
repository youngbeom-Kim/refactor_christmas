package christmas.exception;

public enum ExceptionMessage {

    PREFIX_ERROR("[ERROR] ");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
