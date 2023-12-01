package christmas.constant;

public enum StringConstant {
    DELIMITER(","),
    COUNT_DELIMITER("-");

    private final String message;

    StringConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
