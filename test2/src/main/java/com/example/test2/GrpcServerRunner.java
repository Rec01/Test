package com.example.test2;

import com.example.test2.grpc.GrpcValidateService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Экземпляр gRPC-сервера
 */
@Slf4j
@Service
public class GrpcServerRunner implements DisposableBean {

    private final Server server;

    @Autowired
    public GrpcServerRunner(Test2Properties properties, GrpcValidateService validateService) throws IOException {
        server = ServerBuilder
                .forPort(properties.getGrpcPort())
                .addService(validateService)
                .build();
        server.start();
        log.info("gRPC started at port {}", server.getPort());
        startServerInSeparateThread();
    }

    private void startServerInSeparateThread() {
        Thread awaitThread = new Thread(() -> {
            try {
                server.awaitTermination();
            } catch (Exception ex) {
                log.error("Ошибка в работе gRPC сервера: ", ex);
            }
        });
        awaitThread.setDaemon(false);
        awaitThread.start();
    }

    @Override
    public void destroy() {
        if (server != null) {
            server.shutdown();
        }
    }
}
