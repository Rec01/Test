package com.example.test3.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Сущность, сохраняемая в БД.
 */
@Entity
@Setter
@Getter
@ToString(of = {"id"})
public class EntityData {

    @Id
    @NotBlank
    @Column(nullable = false)
    private String id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    private String data;

    @NotNull
    @Column(nullable = false)
    private Integer value;
}
