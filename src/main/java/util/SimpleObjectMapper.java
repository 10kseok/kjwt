package util;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.StringJoiner;
import jwt.JsonField;

/**
 * Key, Value 값을 Json 형태로 변환하기위한 클래스.
 *
 * @author koesnam (추만석)
 * @since 2023.09.04
 */
public class SimpleObjectMapper {
    private SimpleObjectMapper() {
    }

    public static byte[] writeValueAsBytes(Map<String, Object> source) {
        return writeValueAsString(source).getBytes(StandardCharsets.UTF_8);
    }

    public static String writeValueAsString(Map<String, Object> source) {
        StringJoiner jsonFrameJoiner = getJsonFrameJoiner();
        for (var entry : source.entrySet()) {
            JsonField jsonField = new JsonField(entry.getKey(), String.valueOf(entry.getValue()));
            jsonFrameJoiner.add(jsonField.toJson());
        }
        return jsonFrameJoiner.toString();
    }

    public static StringJoiner getJsonFrameJoiner() {
        return new StringJoiner(",", "{", "}");
    }
}
