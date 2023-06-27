package com.myfitnessapp.security.exception;

import com.myfitnessapp.common.exception.BusinessException;

public class RegisterException extends BusinessException {
    public RegisterException(String message) {
        super(message);
    }
}
