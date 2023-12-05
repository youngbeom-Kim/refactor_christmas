package christmas.domain.order;

public class Reservation {

    private final VisitDate visitDate;
    private final OrderMenu orderMenu;

    public Reservation(VisitDate visitDate, OrderMenu orderMenu) {
        this.visitDate = visitDate;
        this.orderMenu = orderMenu;
    }

}
