package pl.sda.learnjava.LearnJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.learnjava.LearnJava.dto.QuizAnswerDTO;
import pl.sda.learnjava.LearnJava.dto.SimpleAnswer;
import pl.sda.learnjava.LearnJava.repository.QuestionRepository;

@Service
public class QuizAnswerDTOService {
    private QuestionRepository questionRepository;
    @Autowired
    public QuizAnswerDTOService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public int getScore(QuizAnswerDTO quizAnswerDTO) {
        int multiplier = questionRepository.getByName(quizAnswerDTO.getSimpleAnswers().get(0).getQuestion()).getLevel();
        int score = 0;
        for(SimpleAnswer simpleAnswer : quizAnswerDTO.getSimpleAnswers()) {
            if(simpleAnswer.getAnswer() != null && simpleAnswer.getAnswer().equals(questionRepository.getByName(simpleAnswer.getQuestion()).getCorrectAnswer())) {
                score = score + multiplier;
            }
        }
        return score;
    }
}
