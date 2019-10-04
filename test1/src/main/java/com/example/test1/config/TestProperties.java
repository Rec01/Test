package com.example.test1.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "test")
@Getter
@Setter
public class TestProperties {

    private String grpcServerUrl;

    private String dbServiceUrl;

    private Integer httpConnectTimeoutSec;

    private Integer httpReadTimeoutSec;
}
