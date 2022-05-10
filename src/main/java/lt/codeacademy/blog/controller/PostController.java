package lt.codeacademy.blog.controller;

import lt.codeacademy.blog.exeption.PostNotFoundException;
import lt.codeacademy.blog.repository.PostRepository;
import lt.codeacademy.blog.repository.entity.Post;
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

    private PostRepository postRepository;



    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping
    public String getPostList(
            @RequestParam(name = "page", defaultValue = "0") int pageNumber,
            Model model
    ) {
        Pageable pageable = Pageable
                .ofSize(25)
                .withPage(pageNumber);

        Page<Post> postPage = postRepository.findAll(pageable);

        List<Post> post = postPage.getContent();

        model.addAttribute("post", post);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", postPage.getTotalPages());

        return "postList";
    }




    @GetMapping(path = "/{id}")
    public String getPostPage(
            @PathVariable(name = "id") Long id,
//            @RequestParam(name = "showPrice", required = false) boolean showPrice,
            Model model

    ) {
        Optional<Post> foundPost = postRepository.findById(id);

        if (foundPost.isEmpty()) {
            throw new PostNotFoundException();
        }
        Post post = foundPost.get();

//        model.addAttribute("showPrice", showPrice);

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
        Post createdPost = postRepository.save(post);
        model.addAttribute("post", createdPost);
        return "redirect:/post/"+ createdPost.getId();

    }
}