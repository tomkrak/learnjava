package pl.sda.learnjava.LearnJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.learnjava.LearnJava.model.Role;

import java.util.Set;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Set<Role> findAllById(Long id);
    Role findByName(String name);
}
