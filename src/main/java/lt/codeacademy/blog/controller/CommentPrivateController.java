package lt.codeacademy.blog.controller;

import lt.codeacademy.blog.repository.entity.Comment;
import lt.codeacademy.blog.repository.entity.User;
import lt.codeacademy.blog.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "private/posts/{id}/comments")

public class CommentPrivateController {

    private final CommentService commentService;

    public CommentPrivateController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comment")
    public String getCommentForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("comment", new Comment());
        model.addAttribute("postId", id);


        return "commentForm";
    }

    @PostMapping("/create")
    public String createComment(@Valid Comment comment, BindingResult errors, Model model) {
        if (errors.hasErrors()) {


        }
        return "commentForm";
    }
}
//        User user = (User) ScecurityContextHolder.getContext().getPrincipal();
//                comment.setUser(user);












