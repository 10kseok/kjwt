package json;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * {설명을 작성해주세요}
 *
 * @author koesnam (추만석)
 * @since 2023.09.26
 */
class JsonTest {

    @Test
    void testToString() {
        JsonField testJsonField1 = new JsonField("alg", "HS256");
        JsonField testJsonField2 = new JsonField("typ", "JWT");
        Json testJson = new Json(testJsonField1, testJsonField2);
        String expect = testJson.toString();

        assertAll(
                () -> assertTrue(expect.startsWith("{")),
                () -> assertTrue(expect.contains(testJsonField1.getKey())),
                () -> assertTrue(expect.contains(testJsonField1.getValue())),
                () -> assertTrue(expect.contains(testJsonField2.getKey())),
                () -> assertTrue(expect.contains(testJsonField2.getValue())),
                () -> assertTrue(expect.endsWith("}"))
        );
    }
}