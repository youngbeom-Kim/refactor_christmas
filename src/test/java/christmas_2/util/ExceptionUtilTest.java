package christmas_2.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ExceptionUtilTest {

    @Test
    public void 메세지와_IllegalArgumentException_발생() {
        // Given
        String message = "invalid value";

        // When & Then
        assertThatThrownBy(() -> ExceptionUtil.throwInvalidValueException(message))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("invalid value");
    }
}
