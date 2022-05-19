
package lt.codeacademy.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.codeacademy.blog.repository.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}


