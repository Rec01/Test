package com.example.test1.controller;

import com.example.test1.dto.Entity;
import com.example.test1.dto.EntityRequest;
import com.example.test1.dto.EntityResponse;
import com.example.test1.service.PersistenceService;
import com.example.test1.service.ValidationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@Api(tags = "My test API")
@RestController
@RequestMapping(value = "/entities", produces = APPLICATION_JSON_UTF8_VALUE)
// Демонстрируем валидацию бинов
@Validated
@AllArgsConstructor
class TestController {

    private final ValidationService validationService;
    private final PersistenceService persistenceService;

    @ApiOperation("Пример создания сущности")
    @PostMapping
    EntityResponse createEntity(@RequestBody @Valid EntityRequest request) {
        validationService.validate(request);
        return toResponse(persistenceService.persist(toEntity(request)));
    }

    private Entity toEntity(EntityRequest request) {
        final Entity entity = new Entity();
        // используем примитивный маппинг свойств. Существуют более продвинутые библиотеки типа modelmapper и т.п.
        BeanUtils.copyProperties(request, entity);
        entity.setId(UUID.randomUUID().toString());
        return entity;
    }

    private EntityResponse toResponse(Entity entity) {
        return new EntityResponse(entity.getId());
    }

}
