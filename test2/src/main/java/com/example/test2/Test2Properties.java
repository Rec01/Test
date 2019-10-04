package com.example.test2;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "example.test2")
@Getter @Setter
public class Test2Properties {
    private Integer grpcPort;
}
