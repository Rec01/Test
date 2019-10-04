package com.example.test2.grpc;

import com.example.grpc.ValidateServiceGrpc;
import com.example.grpc.ValidateServiceOuterClass;
import com.example.test2.service.ValidateService;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Контроллер для получения gRPC-запросов к микросервису
 */
@Slf4j
@Service
@AllArgsConstructor
public class GrpcValidateService extends ValidateServiceGrpc.ValidateServiceImplBase {

    private final GrpcExecutor grpcExecutor;
    private final ValidateService validateService;

    @Override
    public void validate(ValidateServiceOuterClass.ValidateRequest request, StreamObserver<ValidateServiceOuterClass.ValidateResponse> responseObserver) {
        grpcExecutor.process(responseObserver, () ->
                ValidateServiceOuterClass.ValidateResponse.newBuilder()
                        .setValidateResult(validateService.checkValid(request.getValue()))
                        .build());
    }

}
