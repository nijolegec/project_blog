package lt.codeacademy.blog.controller;

import lt.codeacademy.blog.exeption.PostNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExeptionHandler {
    @ExceptionHandler({PostNotFoundException.class})
    public final String handleExeption(Exception ex, WebRequest request) {
        if (ex instanceof  PostNotFoundException) {
            return "Post not Found";

        }else {
            return "error";
        }
    }
}
