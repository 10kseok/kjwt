package util;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.StringJoiner;
import json.Json;
import json.JsonField;

/**
 * Key, Value 값을 Json 형태로 변환하기위한 클래스.
 *
 * @author koesnam (추만석)
 * @since 2023.09.04
 */
public class SimpleJsonMapper {
    private SimpleJsonMapper() {
    }

    public static byte[] writeValueAsBytes(Map<String, Object> source) {
        return writeValueAsString(source).getBytes(StandardCharsets.UTF_8);
    }

    public static String writeValueAsString(Map<String, Object> source) {
        Json json = new Json();
        for (var entry : source.entrySet()) {
            JsonField jsonField = new JsonField(entry.getKey(), String.valueOf(entry.getValue()));
            json.addField(jsonField);
        }

        return json.toString();
    }
}
