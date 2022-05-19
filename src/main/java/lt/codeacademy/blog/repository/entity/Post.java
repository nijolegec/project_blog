package lt.codeacademy.blog.repository.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "title")
    private  String title;

    @Column(name = "posted_text")
    private  String posted_text;

    @Column(name = "author_name")
    private   String author_name;




}
