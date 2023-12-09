package christmas_2.util;

import java.util.Arrays;
import java.util.List;

public class StringListUtil {

    public static List<String> seperateBy(final String input, final String seprateStandard) {
        return Arrays.stream(input.split(seprateStandard))
                .toList();
    }
}
