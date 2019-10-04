package com.example.test1.config;

import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTParser;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Фиктивный декодер, который на самом деле ничего хорошего не делает, кроме проверки формата токена
 * и проверки эмитента. Никаих подписей не проверяется. Так сделано для упрощения примера и общей инфраструктуры.
 * Сама информация из токена практически полностью игнорируется.
 * В реальном приложении можно использовать NimbusJwtDecoderJwkSupport,
 * который настраивается на сервер авторизации, который предоставляет публичные ключи для проверки токена.
 */
@Component
public class MyJwtDecoder implements JwtDecoder {

    @Override
    public Jwt decode(String token) throws JwtException {
        JWT jwt;
        try {
            jwt = JWTParser.parse(token);
            if (!"com.example".equalsIgnoreCase(jwt.getJWTClaimsSet().getIssuer())) {
                throw new JwtException("Bad issuer");
            }
            Map<String, Object> headers = new HashMap<>();
            headers.put("alg", "HS256");
            headers.put("typ", "JWT");
            Map<String, Object> claims = new HashMap<>();
            claims.put("jti", UUID.randomUUID());
            claims.put("sub", jwt.getJWTClaimsSet().getSubject());
            return new Jwt(token, null, null, headers, claims);
        } catch (ParseException e) {
            throw new JwtException("Bad token format");
        }
    }
}
