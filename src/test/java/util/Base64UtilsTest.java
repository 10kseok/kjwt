package util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * {설명을 작성해주세요}
 *
 * @author koesnam (추만석)
 * @since 2023.09.26
 */
class Base64UtilsTest {

    @Test
    void encode() {
        String expect = "ZW5jb2RpbmdUZXN0"; // https://www.base64encode.org/
        String actual = Base64Utils.encode("encodingTest".getBytes(StandardCharsets.UTF_8));

        assertEquals(expect, actual);
    }

    @Test
    @DisplayName("자체 인코딩을 통한 디코딩 검증")
    void decode() {
        String expect = "decodingTest";
        String actual = Base64Utils.decode(Base64Utils.encode("decodingTest".getBytes(StandardCharsets.UTF_8)));

        assertEquals(expect, actual);
    }

    @Test
    @DisplayName("외부 디코딩을 통한 디코딩 검증")
    void decode2() {
        String expect = "decodingTest"; // https://www.base64decode.org/
        String actual = Base64Utils.decode("ZGVjb2RpbmdUZXN0");

        assertEquals(expect, actual);
    }

    @ParameterizedTest
    @DisplayName("인코딩, 디코딩 통합 검증")
    @ValueSource(strings = {"ge", "", "ewklrj32498rkldsjfgkldjg49e8tu4398tu3tioj43eoi", "\"exp\": 213214", "\"exp\": \"213214\""})
    void total(String text) {
        String encoded = Base64Utils.encode(text.getBytes(StandardCharsets.UTF_8));
        String decoded = Base64Utils.decode(encoded);

        assertEquals(text, decoded);
    }
}