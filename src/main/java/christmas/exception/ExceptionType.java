package christmas.exception;

import static christmas.exception.ExceptionMessage.PREFIX_ERROR;

public interface ExceptionType<T> {

    String errorPrefix = PREFIX_ERROR.getMessage();

    String getMessage();

    T getException();
}
