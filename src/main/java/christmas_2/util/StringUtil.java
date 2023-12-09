package christmas_2.util;

import java.text.DecimalFormat;
import java.util.regex.PatternSyntaxException;

import static christmas_2.constants.PatternConstants.THOUSAND_SEPARATOR;

public final class StringUtil {

    public static String formatByThousandSeparator(final int number) {
        final DecimalFormat decimalFormat = new DecimalFormat(THOUSAND_SEPARATOR.getPattern());
        return decimalFormat.format(number);
    }

    public static String removeAllSpaces(final String input) {
        return input.replace(" ", "");
    }
}
