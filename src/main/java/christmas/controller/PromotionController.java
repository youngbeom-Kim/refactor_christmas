package christmas.controller;

import christmas.domain.benefit.ChampagneGiftGenerator;
import christmas.domain.benefit.DiscountBuilder;
import christmas.domain.benefit.DiscountDirector;
import christmas.domain.benefit.factory.DiscountFactory;
import christmas.domain.order.Menu;
import christmas.domain.order.OrderMenu;
import christmas.domain.order.Reservation;
import christmas.domain.order.VisitDate;
import christmas.domain.order.dto.MenuDto;
import christmas.domain.order.mapper.MenuMapper;
import christmas.domain.result.EventResult;
import christmas.exception.ExceptionHandler;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class PromotionController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    ExceptionHandler exceptionHandler = new ExceptionHandler();

    public void run() {
        Reservation reservation = createReservation();
        EventResult eventResult = createEventResult(reservation);
    }

    private Reservation createReservation() {
        return new Reservation(readVisitDate(), readOrderMenu());
    }

    private VisitDate readVisitDate() {
        outputView.printGreetingMessage();
        return exceptionHandler.exceptionHandler(() -> new VisitDate(inputView.readDate()));
    }

    private OrderMenu readOrderMenu() {
        return exceptionHandler.exceptionHandler(() -> {
           List<MenuDto> orderMenuData = inputView.readMenu();
           List<Menu> orderMenu = orderMenuData.stream().map(MenuMapper::toDomain).toList();

           return new OrderMenu(orderMenu);
        });
    }

    private EventResult createEventResult(Reservation reservation) {
        DiscountDirector discountDirector = initDiscountDirector(reservation);

        return new EventResult(discountDirector.discountAll(), discountDirector.getGifts());
    }

    private DiscountDirector initDiscountDirector(Reservation reservation) {
        List<DiscountBuilder> discountBuilders = DiscountFactory.buildAll(reservation);
        ChampagneGiftGenerator champagneGiftGenerator = new ChampagneGiftGenerator(reservation.getTotalPayment());

        return new DiscountDirector(discountBuilders, champagneGiftGenerator);
    }

}
