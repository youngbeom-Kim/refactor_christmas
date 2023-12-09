package christmas_2.domain.menu;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class MenuTest {

    @ParameterizedTest
    @CsvSource({
            "양송이수프, APPETIZERS",
            "티본스테이크, MAIN_DISHES",
            "초코케이크, DESSERTS",
            "제로콜라, DRINKS"
    })
    public void 아이템이_어떤메뉴에_해당되는지_찾기(String itemName, Menu expectedMenuName) {
        //when
        Menu result = Menu.findMenuType(itemName);

        //Then
        assertThat(result).isEqualTo(expectedMenuName);
    }

    @ParameterizedTest
    @CsvSource({
            "없는메뉴, APPETIZERS",
            "안파는메뉴, MAIN_DISHES",
            "배고픈사람, DESSERTS",
            "오타난음식, DRINKS"
    })
    public void 메뉴판에_없는_아이템을_찾으면_예외_발생(String itemName, Menu expectedMenuName) {
        //When && Then
        assertThatThrownBy(() -> Menu.findMenuType(itemName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 존재하지 않는 메뉴입니다.");
    }
}
