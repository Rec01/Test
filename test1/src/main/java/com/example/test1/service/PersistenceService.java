package com.example.test1.service;

import com.example.test1.config.TestProperties;
import com.example.test1.dto.Entity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * Сервис сохранения данных. В реальности вызывает отдельный микросервис через REST API,
 * которому передает данные для сохранения.
 */
@Slf4j
@Service
public class PersistenceService {

    private HttpTransport transport;

    @Autowired
    public PersistenceService(HttpTransport transport) {
        this.transport = transport;
    }

    /**
     * Сохранить сущность в БД.
     *
     * @param entity сущность
     * @return та же сущность
     */
    public Entity persist(Entity entity) {
        transport.asyncRequest(entity);
        return entity;
    }

    @Service
    public static class HttpTransport {

        private final RestTemplate restTemplate;

        @Autowired
        public HttpTransport(TestProperties testProperties, RestTemplateBuilder restTemplateBuilder) {
            this.restTemplate = restTemplateBuilder
                    .setConnectTimeout(Duration.ofSeconds(testProperties.getHttpConnectTimeoutSec()))
                    .setReadTimeout(Duration.ofSeconds(testProperties.getHttpReadTimeoutSec()))
                    .rootUri(testProperties.getDbServiceUrl())
                    .build();
        }

        /**
         * Асинхронное обращение к REST API микросервиса, взаимодействующего с БД.
         * В задании не было информации о том, что нужно контролировать результат в первом сервисе.
         * Асинхронное сохранение дает примерно 2-х кратный рост производительности системы.
         * В реальной системе лучше использовать что-то из области очередей (JMS, RabbitMQ и т.п.)
         * Здесь это не применено, чтобы не развертывать инфраструктуру.
         */
        @Async
        public void asyncRequest(Entity entity) {
            try {
                final HttpEntity<Entity> request = new HttpEntity<>(entity);
                restTemplate.exchange("/entities", HttpMethod.POST, request, String.class);
            } catch (Exception ex) {
                log.error("Error on process http call to test3 service: {} - {}",
                        ex.getClass().getSimpleName(), NestedExceptionUtils.getMostSpecificCause(ex).getMessage());
            }
        }
    }

}
