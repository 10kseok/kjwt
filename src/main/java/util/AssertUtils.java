package util;

import java.util.Objects;

/**
 * {설명을 작성해주세요}
 *
 * @author koesnam (추만석)
 * @since 2023.09.04
 */
public class AssertUtils {
    private AssertUtils() {
    }

    public static void hasLength(CharSequence letters, String message) {
        if (Objects.isNull(letters) || letters.length() == 0) {
            throw new IllegalArgumentException(message);
        }
    }
}
