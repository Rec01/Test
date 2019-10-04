package com.example.test1.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@ApiModel("Пример ответа")
@Getter
@AllArgsConstructor
public class EntityResponse {
    private String id;
}
