package com.example.dzr.Exception;

import lombok.Data;

@Data
public class AppError {
    private int statusCode;
    private String message;
}