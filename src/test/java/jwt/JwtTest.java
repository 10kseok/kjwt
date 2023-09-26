package jwt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * {설명을 작성해주세요}
 *
 * @author koesnam (추만석)
 * @since 2023.09.04
 */
class JwtTest {
    @Test
    @DisplayName("Jwt 객체 생성시 .으로 구분되고 있다.")
    void create() {
        Jwt testJwt = new Jwt("header", "payload", "signature");
        assertEquals("header.payload.signature", testJwt.toString());
    }

    @Test
    @DisplayName("Jwt 객체 생성시 헤더, 페이로드, 시그니처 세 개로 구성되어 있다.")
    void create_2() {
        Jwt testJwt = new Jwt("header", "payload", "signature");
        assertEquals(3, testJwt.toString().split("\\.").length);
    }
}