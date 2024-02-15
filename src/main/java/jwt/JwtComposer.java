package jwt;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import util.Base64Utils;
import util.SimpleJsonMapper;

/**
 * Json Web Token을 발행하는 클래스
 *
 * @author koesnam (추만석)
 * @since 2023.09.04
 */
public class JwtComposer {
    public static Jwt compose(Map<String, Object> header, Map<String, Object> payload, byte[] secret)
            throws NoSuchAlgorithmException, InvalidKeyException {
        String jsonHeader = encode(SimpleJsonMapper.writeValueAsBytes(header));
        String jsonPayload = encode(SimpleJsonMapper.writeValueAsBytes(payload));
        String signature = encode(sign(jsonHeader + "." + jsonPayload, secret, "HmacSHA256"));
        return new Jwt(jsonHeader, jsonPayload, signature);
    }

    private static String encode(byte[] src) {
        return Base64Utils.encode(src);
    }

    private static byte[] sign(String data, byte[] secret, String algorithm) throws NoSuchAlgorithmException,
            InvalidKeyException {
        SecretKeySpec secretKey = new SecretKeySpec(secret, algorithm);
        Mac mac = Mac.getInstance(algorithm);
        mac.init(secretKey);
        return mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
    }
}
