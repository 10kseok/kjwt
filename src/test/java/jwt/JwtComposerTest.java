package jwt;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import junit.framework.TestCase;

/**
 * {설명을 작성해주세요}
 *
 * @author koesnam (추만석)
 * @since 2023.09.04
 */
public class JwtComposerTest extends TestCase {

    public void testCreateJwt() throws NoSuchAlgorithmException, InvalidKeyException {
        Map<String, Object> expectHeader = Map.of("alg", "HS256", "typ", "JWT");
        Map<String, Object> expectPayload = Map.of("jti", 1, "iss", LocalDate.now().toString());
        String actual = JwtComposer.createToken(expectHeader, expectPayload, "jwtSecretForHMACWithSHA-256".getBytes(StandardCharsets.UTF_8));
        System.out.println(actual);
    }
}