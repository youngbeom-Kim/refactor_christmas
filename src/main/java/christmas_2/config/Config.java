package christmas_2.config;

import christmas_2.controller.OrderController;
import christmas_2.service.OrderService;
import christmas_2.view.InputView;
import christmas_2.view.OutputView;
import christmas_2.view.StartView;

public interface Config {
    OrderController orderController();
    OrderService orderService();
    StartView startView();
    InputView inputView();
    OutputView outputView();
}
