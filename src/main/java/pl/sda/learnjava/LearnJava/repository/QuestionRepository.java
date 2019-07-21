package pl.sda.learnjava.LearnJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.learnjava.LearnJava.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
