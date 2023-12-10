package christmas_2.view;

import christmas_2.domain.dto.MemberBadgeDto;
import christmas_2.domain.dto.OrderBenefitsDto;
import christmas_2.domain.dto.OrderItemsDto;

public interface OutputView {

    void outputPreviewTitle();

    void outputOrderItems(OrderItemsDto orderItemsDto);

    void outputBenefits(OrderBenefitsDto orderBenefitsDto);

    void outputThisMonthBadge(MemberBadgeDto memberBadgeDto);
}
