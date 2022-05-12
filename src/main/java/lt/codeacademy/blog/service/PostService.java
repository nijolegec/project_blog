package lt.codeacademy.blog.service;

import lt.codeacademy.blog.exeption.PostNotFoundException;
import lt.codeacademy.blog.repository.PostRepository;
import lt.codeacademy.blog.repository.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {

        this.postRepository = postRepository;
    }

    public Post create(Post post) {
        return postRepository.save(post);
    }

    public Post findById(Long id) {
        return postRepository
                .findById(id)
                .orElseThrow(PostNotFoundException::new);
    }
    public Page<Post>findAllPageable(int pageSize, int pageNumber) {
        Pageable pageable = Pageable
                .ofSize(pageSize)
                .withPage(pageNumber);
        return postRepository.findAll(pageable);

    }

}
