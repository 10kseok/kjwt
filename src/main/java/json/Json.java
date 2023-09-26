package json;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * {설명을 작성해주세요}
 *
 * @author koesnam (추만석)
 * @since 2023.09.25
 */
public class Json {
    private final StringJoiner frame;
    private final List<JsonField> properties;

    public Json(JsonField... jsonFields) {
        frame = new StringJoiner(",", "{", "}");
        properties = new ArrayList<>();
        properties.addAll(List.of(jsonFields));
    }

    public void addField(JsonField jsonField) {
        properties.add(jsonField);
    }

    public JsonField getField(String key) {
        return properties.stream()
                .filter(jsonField -> jsonField.getKey().equals(key))
                .findAny()
                .orElse(null);
    }

    @Override
    public String toString() {
        properties.stream()
                .map(JsonField::toString)
                .forEach(frame::add);
        return frame.toString();
    }
}