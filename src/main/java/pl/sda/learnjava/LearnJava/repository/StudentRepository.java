package pl.sda.learnjava.LearnJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.learnjava.LearnJava.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}