package util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * {설명을 작성해주세요}
 *
 * @author koesnam (추만석)
 * @since 2023.09.26
 */
public class Base64Utils {
    private Base64Utils() {}

    public static String encode(byte[] src) {
        return Base64.getUrlEncoder()
                .withoutPadding()
                .encodeToString(src);
    }

    public static String decode(String src) {
        return new String(decode(src, StandardCharsets.UTF_8), StandardCharsets.UTF_8);
    }

    private static byte[] decode(String src, Charset charsets) {
        return Base64.getUrlDecoder()
                .decode(src.getBytes(charsets));
    }
}
