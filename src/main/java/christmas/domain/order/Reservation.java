package christmas.domain.order;

import java.util.List;

public class Reservation {

    private final VisitDate visitDate;
    private final OrderMenu orderMenu;

    public Reservation(VisitDate visitDate, OrderMenu orderMenu) {
        this.visitDate = visitDate;
        this.orderMenu = orderMenu;
    }

    public int getTotalPayment() {
        return orderMenu.getTotalPayment();
    }

    public int getVisitDayOfMonth() {
        return visitDate.getDayOfMonth();
    }

    public List<Menu> getOrderMenu() {
        return orderMenu.getOrderMenu();
    }

    public int getDessertMenuCount() {
        return orderMenu.getDessertMenuCount();
    }

    public int getMainMenuCount() {
        return orderMenu.getMainMenuCount();
    }

    public boolean isSunday() {
        return visitDate.isSunday();
    }

    public boolean isChristmas() {
        return visitDate.isChristmas();
    }

    public boolean isWeekDay() {
        return visitDate.isWeekDay();
    }

    public boolean isWeekEnd() {
        return visitDate.isWeekEnd();
    }

}
