package pl.sda.learnjava.LearnJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.learnjava.LearnJava.model.Student;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByLogin(String login);
}