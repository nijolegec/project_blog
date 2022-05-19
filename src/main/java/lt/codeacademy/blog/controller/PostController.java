package lt.codeacademy.blog.controller;

import lt.codeacademy.blog.exeption.PostNotFoundException;
import lt.codeacademy.blog.repository.PostRepository;
import lt.codeacademy.blog.repository.entity.Post;
import lt.codeacademy.blog.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {

        this.postService = postService;
    }

    @GetMapping
    public String getPostList(
            @RequestParam(name = "page", defaultValue = "0") int pageNumber,
            Model model
    ) {


       Page<Post>postPage= postService.findAllPageable(25, pageNumber);

        List<Post> post = postPage.getContent();

        model.addAttribute("post", post);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", postPage.getTotalPages());

        return "postList";
    }




    @GetMapping(path = "/{id}")
    public String getPostPage(
            @PathVariable(name = "id") Long id,

            Model model

    ) {
        Post post = postService.findById(id);

        model.addAttribute("post", post);


        return "postPage";
    }

    @GetMapping("/post")
    public String getPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "postForm";
    }

    @PostMapping("/create")
    public String createPost(Post post, Model model) {
        Post createdPost = postService.create(post);
        model.addAttribute("post", createdPost);
        return "redirect:/post/"+ createdPost.getId();



    }
}