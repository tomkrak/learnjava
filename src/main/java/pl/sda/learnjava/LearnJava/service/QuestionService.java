package pl.sda.learnjava.LearnJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.learnjava.LearnJava.dto.QuestionDTO;
import pl.sda.learnjava.LearnJava.model.Question;
import pl.sda.learnjava.LearnJava.repository.QuestionRepository;

import java.util.List;
import java.util.Set;

@Service
public class QuestionService {
    private QuestionRepository questionRepository;

    public QuestionService() {
    }

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getQuestions() {
        return questionRepository.findAll();
    }

    public void addQuestion(QuestionDTO questionDTO) {
        questionRepository.save(questionDTO.questionDTOTOQuestion());
    }

    public Set<String> getQuestionsLevel(){
        return questionRepository.findQuestionsLevels();
    }
    public List<Question> findByLevel(Integer level){
        return questionRepository.findByLevel(level);
    }


}