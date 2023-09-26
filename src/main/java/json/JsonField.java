package json;

import lombok.Getter;

/**
 * Json 필드값을 정의하기 위한 클래스.
 *
 * @author koesnam (추만석)
 * @since 2023.09.04
 */
@Getter
public class JsonField {
    private final String key;
    private final String value;

    public JsonField(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("\"%s\": \"%s\"", key, value);
    }
}
