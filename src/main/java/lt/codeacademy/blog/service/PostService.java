package lt.codeacademy.blog.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.blog.exeption.PostNotFoundException;
import lt.codeacademy.blog.repository.CommentRepository;
import lt.codeacademy.blog.repository.PostRepository;
import lt.codeacademy.blog.repository.UserRepository;
import lt.codeacademy.blog.repository.entity.Post;
import lt.codeacademy.blog.repository.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    public Post create(Post post) {
//        User author= userRepository.getById(userId);
//        post.setUser(author);

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
