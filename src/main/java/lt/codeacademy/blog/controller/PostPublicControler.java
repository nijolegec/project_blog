package lt.codeacademy.blog.controller;

import lombok.RequiredArgsConstructor;
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

public class PostPublicControler {
    @Controller
    @RequestMapping("/post/post")
    @RequiredArgsConstructor
    public class PostPublicController {
        private final PostService postService;
        @GetMapping
        public String getProductList(
                @RequestParam(name = "page", defaultValue = "0") int pageNumber,
                Model model
        ) {
            Page<Post> postPage = postService.findAllPageable(25, pageNumber);
            List<Post> post = postPage.getContent();
            model.addAttribute("post", post);
            model.addAttribute("currentPage", pageNumber);
            model.addAttribute("totalPages", postPage.getTotalPages());
            return "productList";
        }
        @GetMapping(path = "/{id}")
        public String getProductPage(
                @PathVariable(name = "id") Long id,

                Model model
        ) {
            Post post = postService.findById(id);

            model.addAttribute("post", post);
            return "postPage";
        }
    }
}
