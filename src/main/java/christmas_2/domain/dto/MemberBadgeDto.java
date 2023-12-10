package christmas_2.domain.dto;

public class MemberBadgeDto {

    private final String badge;

    public MemberBadgeDto(final String badge) {
        this.badge = badge;
    }

    public String getBadge() {
        return badge;
    }
}
