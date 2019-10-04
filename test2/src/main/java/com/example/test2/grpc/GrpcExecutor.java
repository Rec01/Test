package com.example.test2.grpc;

import com.google.protobuf.MessageOrBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

/**
 * Вспомогательные методы для обработки полученных gRPC запросов
 */
@Slf4j
@Component
public class GrpcExecutor {

    public <T extends MessageOrBuilder> void process(StreamObserver<T> observer, Supplier<T> function) {
        try {
            T ret = function.get();
            observer.onNext(ret);
            observer.onCompleted();
        } catch (Exception ex) {
            log.error("Error on process gRPC call: {} - {}",
                    ex.getClass().getSimpleName(), NestedExceptionUtils.getMostSpecificCause(ex).getMessage());
            observer.onError(ex);
        }
    }

}
