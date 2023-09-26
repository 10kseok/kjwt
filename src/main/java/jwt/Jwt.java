package jwt;

import java.io.Serializable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * {설명을 작성해주세요}
 *
 * @author koesnam (추만석)
 * @since 2023.09.04
 */
@Getter
@RequiredArgsConstructor
public class Jwt implements Serializable {
    private final String header;
    private final String payload;
    private final String signature;

    @Override
    public String toString() {
        return String.format("%s.%s.%s", header, payload, signature);
    }
}
