package com.example.test3.controller;

import com.example.test3.error.ConflictError;
import com.example.test3.error.NotFoundError;
import com.example.test3.model.EntityData;
import com.example.test3.repository.EntityDataRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@Api(tags = "My Persistence Controller")
@RestController
@AllArgsConstructor
@RequestMapping(value = "/entities", produces = APPLICATION_JSON_UTF8_VALUE)
@Validated
public class TestController {

    private final EntityDataRepository entityDataRepository;

    @ApiOperation("Создать сущность")
    @PostMapping
    EntityData create(@RequestBody @Valid EntityData data) {
        if (entityDataRepository.existsById(data.getId()))
            throw new ConflictError(String.format("Сущность %s уже создана", data));
        entityDataRepository.save(data);
        return data;
    }

    @ApiOperation("Получить сущность")
    @GetMapping("/{id}")
    EntityData get(@PathVariable @ApiParam("идентификатор сущности") String id) {
        return entityDataRepository.findById(id).orElseThrow(NotFoundError::new);
    }

    @ApiOperation("Получить сущности  с постраничным выводом")
    @GetMapping
    Page<EntityData> getList(@RequestParam(defaultValue = "0") @ApiParam("страница") int page,
                             @RequestParam(defaultValue = "10") @ApiParam("размер страницы") int pageSize) {

        return entityDataRepository.findAll(
                PageRequest.of(page, pageSize, Sort.unsorted()));
    }

}
