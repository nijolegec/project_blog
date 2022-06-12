package lt.codeacademy.blog.controller;

import lt.codeacademy.blog.exeption.PostNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({PostNotFoundException.class})
    public final String handleException(Exception ex, WebRequest request) {



            return "error";
        }
    }

