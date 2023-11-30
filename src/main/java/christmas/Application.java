package christmas;

import christmas.controller.PromotionController;
import christmas.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PromotionController promotionController = new PromotionController();

        promotionController.run();
    }
}
