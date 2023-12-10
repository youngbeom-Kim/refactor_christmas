package christmas_2.controller;

import christmas_2.service.OrderService;
import christmas_2.view.InputView;
import christmas_2.view.OutputView;
import christmas_2.view.StartView;

public class OrderController {

    private final StartView startView;
    private final InputView inputView;
    private final OutputView outputView;
    private final OrderService orderService;

    public OrderController(final StartView startView,
                           final InputView inputView,
                           final OutputView outputView,
                           final OrderService orderService) {
        this.startView = startView;
        this.inputView = inputView;
        this.outputView = outputView;
        this.orderService = orderService;
    }

    public void order() {
        printStartMessage();
    }

    private void printStartMessage() {
        startView.printWelcomeMessage();
        startView.printMenu();
        startView.printPrecaution();
    }
}
