package util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * {설명을 작성해주세요}
 *
 * @author koesnam (추만석)
 * @since 2023.09.04
 */
class SimpleJsonMapperTest {
    @Test
    void testWriteValueAsString() {
        Map<String, Object> expect = new HashMap<>();
        expect.put("alg", "HS256");
        expect.put("typ", "JWT");
        String actual = SimpleJsonMapper.writeValueAsString(expect);

        assertTrue(actual.startsWith("{"));
        assertTrue(actual.endsWith("}"));
        assertEquals(2, actual.split(",").length);
        System.out.println(actual);
    }
}
