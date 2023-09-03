package jwt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Json Web Token을 발행하는 클래스
 *
 * @author koesnam (추만석)
 * @since 2023.09.04
 */
public class JwtComposer {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static Jwt createJwt(Map<String, String> header, Map<String, String> payload, String secret)
            throws JsonProcessingException, NoSuchAlgorithmException, InvalidKeyException {
        String jsonHeader = encode(objectMapper.writeValueAsBytes(header));
        String jsonPayload = encode(objectMapper.writeValueAsBytes(payload));
        // TODO 1-1: 서명에 사용될 알고리즘 선정하기 (우선은 HMAC 으로만)
        String signature = encode(sign(jsonHeader + "." + jsonPayload, secret.getBytes(StandardCharsets.UTF_8), ""));
        return new Jwt(jsonHeader, jsonPayload, signature);
    }

    private static String encode(byte[] src) {
        Base64.Encoder encoder = Base64.getUrlEncoder();
        return encoder.encodeToString(src);
    }

    public static byte[] sign(String data, byte[] secret, String algorithms) throws NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec secretKey = new SecretKeySpec(secret, algorithms);
        Mac mac = Mac.getInstance(algorithms);
        mac.init(secretKey);
        return mac.doFinal(data.getBytes());
    }
}
