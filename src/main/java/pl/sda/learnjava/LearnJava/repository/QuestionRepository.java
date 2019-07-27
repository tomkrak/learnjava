package pl.sda.learnjava.LearnJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.learnjava.LearnJava.model.Question;

import java.util.List;
import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Query(value = "SELECT q.level FROM Question q")
    Set<String> findQuestionsLevels();
    List<Question> findByLevel(int level);
}