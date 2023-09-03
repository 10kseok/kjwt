import junit.framework.TestCase;
import jwt.Jwt;

/**
 * {설명을 작성해주세요}
 *
 * @author koesnam (추만석)
 * @since 2023.09.04
 */
public class JwtTest extends TestCase {
    public void testCompose() {
        Jwt testJwt = new Jwt("header", "payload", "signature");
        assertEquals("header.payload.signature", testJwt.compose());
    }
}