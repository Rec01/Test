package com.example.test2.service;

import org.springframework.stereotype.Service;

/**
 * Сервис для валидации бизнес данных
 */
@Service
public class ValidateService {

    /**
     * Для примера, валидными являются запросы, поле value которых чётно
     */
    public String checkValid(Integer value) {
        return value % 2 == 0 ? "" : "Поле value не прошло проверку: значение должно быть чётным";
    }

}
