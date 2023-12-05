package christmas.exception;

import christmas.view.OutputView;

import java.util.function.Supplier;

public class ExceptionHandler {

    OutputView outputView = new OutputView();

    public <T> T exceptionHandler(Supplier<T> reader) {
        while (true) {
            try {
                return reader.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
