package lt.codeacademy.blog.repository.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private  String title;

    @Column(name = "text")
    private  String text;

    @Column(name = "author_name")
    private   String author_name;

    public void setPost(Post post) {

    }
}
