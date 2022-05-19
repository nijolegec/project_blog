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
@RequestMapping(path = "/post")
@RequiredArgsConstructor
public class PostPrivateController {

    private final PostService postService;

    @GetMapping("/post")
    @PreAuthorize("hasRole('ADMIN')")
    public String createProduct(@Valid Post post, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            return "productForm";
        }
        Post createdProduct = postService.create(post);
        model.addAttribute("product", createdProduct);
        return "redirect:/products/" + createdProduct.getId();
    }

    @ModelAttribute("product")
    public Post populateEmptyProduct() {

        return new Post();
    }

}


//    @GetMapping(path = "/{id}")
//    public String getPostPage(
//            @PathVariable(name = "id") Long id,
//
//            Model model
//
//    ) {
//        Post post = postService.findById(id);
//
//        model.addAttribute("post", post);
//
//
//        return "postPage";
//    }
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