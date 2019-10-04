package com.example.test1.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("Пример запроса")
@Setter
@Getter
@ToString
public class EntityRequest {
    @NotBlank
    private String name;
    private String data = "";
    @NotNull
    private Integer value;
}
