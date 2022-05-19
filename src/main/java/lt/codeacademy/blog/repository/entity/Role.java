package lt.codeacademy.blog.repository.entity;

import lombok.Data;

import javax.persistence.*;
@Entity
@Table(name="roles")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Enumerated(EnumType.STRING)
    private Authority role;

}


