package com.demo.hibernate.core.common;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ErrorCode {

    ENTITY_NOT_FOUND("ERR001", "Entity not found."),
    ENTITY_SAVE_FAILED("ERR002", "Failed to save the entity."),
    SERVER_FAILED("ERR100", "Server failed to complete this request.");

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
