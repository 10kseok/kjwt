# JWT 생성기 (Java)

이 프로젝트는 Java를 사용하여 JSON Web Token (JWT)을 생성하는 기능을 구현한 것입니다.

## 설치 및 사용법

1. 프로젝트를 클론합니다:
```bash
git clone https://github.com/10kseok/kjwt.git
```

2. 프로젝트 디렉토리로 이동합니다:
```bash
cd kjwt
```

3. 프로젝트를 빌드합니다:
```bash
mvn clean install
```

4. 사용 예시:
```java
// 헤더 설정
Map<String, Object> header = new HashMap<>();
header.put("alg", "HS256");
header.put("typ", "JWT");

// 페이로드 설정
Map<String, Object> payload = new HashMap<>();
payload.put("user_id", "123456");
payload.put("username", "amugae");

// 비밀번호(시크릿) 설정
byte[] secret = "jwtSecretForHMACWithSHA-256".getBytes(StandardCharsets.UTF_8);

// JWT 생성
Jwt jwt = JwtComposer.compose(header, payload, secret);

// 생성된 JWT 출력
System.out.println("Generated JWT: " + jwt);
```

## 기능
1. JSON Web Token (JWT)을 생성할 수 있습니다.
2. 페이로드에 사용자 지정 데이터를 추가할 수 있습니다.
3. 서명 및 만료 시간을 지정할 수 있습니다.

## 기여
기여는 언제나 환영합니다! 버그를 발견하거나 기능 제안이 있으시면 이슈를 열어주시거나 Pull Request를 보내주세요.
