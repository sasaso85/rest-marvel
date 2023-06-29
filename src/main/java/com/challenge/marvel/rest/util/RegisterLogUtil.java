package com.challenge.marvel.rest.util;

import com.challenge.marvel.rest.model.RegisterLog;

import java.time.LocalDateTime;

public class RegisterLogUtil {
    public static RegisterLog createRegister(int status, String api) {
        return RegisterLog.builder()
                .api(api)
                .status(status)
                .invocationDateTime(LocalDateTime.now())
                .build();
    }
}
