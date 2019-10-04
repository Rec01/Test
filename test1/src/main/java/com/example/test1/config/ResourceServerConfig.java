package com.example.test1.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.web.util.matcher.RequestHeaderRequestMatcher;

/**
 * Конфигурация сервера ресурсов
 */
@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

    private final MyJwtDecoder jwtDecoder;

    private static String[] whitelist = {
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // нет сессии
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()

                // разрешаем работу со сваггером без авторизации
                .antMatchers(whitelist).permitAll()

                // Запретим доступ, если нет заголовка X-MyHeader = test
                // Можно еще написать фильтр или использовать HttpServletRequest в методе контроллера
                .requestMatchers(new NegatedRequestMatcher(
                        new RequestHeaderRequestMatcher("X-MyHeader", "test")))
                .denyAll()

                .antMatchers("/**").authenticated()
                .and()
                .oauth2ResourceServer()
                // подключаем авторизацию по jwt-токенам и предоставляем декодер
                .jwt().decoder(jwtDecoder);
    }

}
