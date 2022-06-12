package lt.codeacademy.blog.controller;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.blog.repository.entity.Comment;
import lt.codeacademy.blog.repository.entity.Post;
import lt.codeacademy.blog.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/public/posts/{id}/comments")
@RequiredArgsConstructor
public class CommentPublicControler {
    private final PostService postService;

    @GetMapping
    public String getCommentList(
            @RequestParam(name = "page", defaultValue = "0") int pageNumber,
            Model model
    ) {
        Page<Post> postPage = postService.findAllPageable(25, pageNumber);

        model.addAttribute("comment", new Comment());


        return "commentForm";


        }
    }

