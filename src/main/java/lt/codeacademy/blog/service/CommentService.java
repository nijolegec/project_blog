package lt.codeacademy.blog.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.blog.repository.CommentRepository;
import lt.codeacademy.blog.repository.entity.Comment;
import lt.codeacademy.blog.repository.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.naming.CommunicationException;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostService postService ;


        public Comment create(Comment comment, Long postId) {
        Post post = postService.findById(postId);
        comment.setPost(post);
//            post.getComments().add(comment);
        return commentRepository.save(comment);
    }
    public Comment findById(Long id) throws CommunicationException {
        return commentRepository
                .findById(id)
                .orElseThrow(CommunicationException::new);

    }
public Page<lt.codeacademy.blog.repository.entity.Comment> findAllPageable(int pageSize, int pageNumber) {
        Pageable pageable = Pageable
                .ofSize(pageSize)
                .withPage(pageNumber);
        return commentRepository.findAll(pageable);
}

}
