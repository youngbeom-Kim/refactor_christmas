package christmas_2.validation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class MapValidatorTest {

    private static final String name1 = "Item1";
    private static final String name2 = "Item2";
    private static final String name3 = "Item3";
    private static final String name4 = "Item4";
    private static final int count1 = 1;
    private static final int count2 = 2;
    private static final Map<String, Integer> testMap = new HashMap<>() {{
        put(name1,count1);
        put(name2,count2);
    }};

    @ParameterizedTest(name = "맵에는 이미 Key {0}가 있으므로 예외 발생")
    @CsvSource({name1, name2})
    public void 중복키가_이미_있을때_예외발생(final String key) {
        assertThatThrownBy(() -> MapValidator.validateDuplicateKey(testMap, key))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "맵에는 이미 Key {0}가 없으므로 정상 통과없으므로 정상 통과")
    @ValueSource(strings = {name3, name4})
    public void 중복키가_없으면_정상_통과(final String key) {
        MapValidator.validateDuplicateKey(testMap, key);
    }

    @Test
    public void 맵이_비어있으면_예외_처리() {
        final Map<String, Integer> emptyMap = new HashMap<>();
        assertThatThrownBy(() -> MapValidator.validateNotEmpty(emptyMap))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 맵이_비어있지_않으면_정상_통과() {
        MapValidator.validateNotEmpty(testMap);
    }
}
