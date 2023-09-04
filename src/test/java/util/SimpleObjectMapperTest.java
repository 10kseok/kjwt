package util;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import junit.framework.TestCase;

/**
 * {설명을 작성해주세요}
 *
 * @author koesnam (추만석)
 * @since 2023.09.04
 */
public class SimpleObjectMapperTest extends TestCase {
    public void testWriteValueAsString() {
        Map<String, Object> expect = new HashMap<>();
        expect.put("alg", "HS256");
        expect.put("typ", "JWT");
        String actual = SimpleObjectMapper.writeValueAsString(expect);

        assertTrue(actual.startsWith("{"));
        assertTrue(actual.endsWith("}"));
        assertEquals(2, actual.split(",").length);
        System.out.println(actual);
    }
}
