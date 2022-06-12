package lt.codeacademy.blog.controller;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.blog.repository.entity.Post;
import lt.codeacademy.blog.service.PostService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/private/post")
@RequiredArgsConstructor
public class PostPrivateController {

    private final PostService postService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String getPostForm(Model model) {
        return "postForm";
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")

    public String createPost(@Valid Post post, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            return "postForm";
        }

        Post createdPost = postService.create(post);

        model.addAttribute("post", createdPost);
        return "redirect:/public/post/" + createdPost.getId();
    }

    @ModelAttribute("post")
    public Post populateEmptyPost() {

        return new Post();
    }

}


//    @GetMapping("/delete{id}")
//    public String deletePost(
//            @PathVariable(name="id") Long id {
//                postService.delete(id);
//    }
//    )
//}
//
//    @GetMapping("/post")
//    public String getPostForm(Model model) {
//        model.addAttribute("post", new Post());
//        return "postForm";
//    }
//
//    @PostMapping("/create")
//    public String createPost(Post post, Model model) {
//        Post createdPost = postService.create(post);
//        model.addAttribute("post", createdPost);
//        return "redirect:/post/"+ createdPost.getId();


//
//    }
//}