package dev.seanrogan.gallery.repository;

import dev.seanrogan.gallery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
