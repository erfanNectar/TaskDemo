package com.example.UserRegisteration.Util;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Data
@SuperBuilder
public class Response<T> {
    private LocalDateTime timeStamp;
    private int statusCode;
    private HttpStatus status;
    private String reason;
    private String message;
    private String developerMessage;
    private T data;
}
