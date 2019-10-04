package com.example.test1.config;

import com.example.grpc.ValidateServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Настройка клиента gRPC
 */
@Configuration
public class GrpcConfig {

    private final TestProperties properties;
    private ManagedChannel acquiringGrpcChannel;

    public GrpcConfig(TestProperties properties) {
        this.properties = properties;
    }

    @PostConstruct
    public void initGrpcChannels() {
        acquiringGrpcChannel = ManagedChannelBuilder.forTarget(properties.getGrpcServerUrl()).usePlaintext().build();
    }

    @Bean
    public ValidateServiceGrpc.ValidateServiceBlockingStub acquiringGrpcService() {
        return ValidateServiceGrpc.newBlockingStub(acquiringGrpcChannel);
    }

}
