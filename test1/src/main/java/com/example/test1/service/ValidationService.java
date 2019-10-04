package com.example.test1.service;

import com.example.grpc.ValidateServiceGrpc;
import com.example.grpc.ValidateServiceOuterClass.ValidateRequest;
import com.example.test1.dto.EntityRequest;
import com.example.test1.error.ValidationException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Сервис валидации. В реальности вызывает через gRPC отдельный микросервис валидации.
 */
@Service
@AllArgsConstructor
@Slf4j
public class ValidationService {

    private final ValidateServiceGrpc.ValidateServiceBlockingStub validateService;

    /**
     * Проверяет объект на корректность.
     *
     * @param request проверяемый объект
     * @throws ValidationException при наличии ошибок в объекте
     */
    public void validate(EntityRequest request) {
        // Создаем объект для передачи в gRPC
        final ValidateRequest validateRequest = ValidateRequest.newBuilder()
                .setName(request.getName())
                .setData(request.getData())
                .setValue(request.getValue())
                .build();
        // Синхронный вызов
        log.debug("Making gRPC call to Validation service with data = {}", request);
        final String result = validateService.validate(validateRequest).getValidateResult();
        // Проверка результата
        if (!StringUtils.isEmpty(result)) {
            throw new ValidationException(result);
        }
    }
}
