package jwt;

import java.io.Serializable;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import util.AssertUtils;

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

    public String compose() {
        AssertUtils.hasLength(header, "헤더가 비었습니다");
        AssertUtils.hasLength(payload, "데이터가 비었습니다");
        AssertUtils.hasLength(signature, "서명이 비었습니다");
        StringJoiner joiner = new StringJoiner(".");
        return joiner.add(header)
                .add(payload)
                .add(signature)
                .toString();
    }

    @Override
    public String toString() {
        return this.compose();
    }
}
