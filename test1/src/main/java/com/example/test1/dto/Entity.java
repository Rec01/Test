package com.example.test1.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Сущность, отправляемая в БД.
 */
@Setter
@Getter
public class Entity {
    private String id;
    private String name;
    private String data;
    private Integer value;
}
