package lt.codeacademy.blog.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Post was not found")
public class PostNotFoundException extends RuntimeException {
}
