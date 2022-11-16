package dev.seanrogan.gallery.repository;

import dev.seanrogan.gallery.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
 Role findByName(String name);

}
