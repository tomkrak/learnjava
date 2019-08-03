package pl.sda.learnjava.LearnJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.learnjava.LearnJava.dto.QuestionDTO;
import pl.sda.learnjava.LearnJava.model.Question;
import pl.sda.learnjava.LearnJava.repository.QuestionRepository;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    public Set<Integer> getQuestionsLevel() {
        return questionRepository.findQuestionsLevels();
    }

    public Map<Integer, String> getQuestionsLevelAsMap() {
        Map<Integer, String> levelsMap = new HashMap<>();
        levelsMap.put(1, "Poziom początkujący");
        levelsMap.put(2, "Poziom średniozaawansowany");
        levelsMap.put(3, "Poziom zaawansowany");
        return levelsMap;

    }

    public List<Question> findByLevel(Integer level) {
        return questionRepository.findByLevel(level);
    }

    public Question getByName(String name) {
        return questionRepository.getByName(name);
    }

    public List<Question> findRandomFiveByLevel(Integer level, Set<Question> criteriaSet) {
        Random random = new Random();
        List<Question> allQuestions = questionRepository.findByLevel(level);
        allQuestions.removeAll(criteriaSet);
        int numberOfQuestions = allQuestions.size();
        List<Question> randomQuestions = new ArrayList<>();
        if (allQuestions.size() >= 5) {
            while (randomQuestions.size() < 5) {
                int r = random.nextInt(numberOfQuestions);
                if (!randomQuestions.contains(allQuestions.get(r))) {
                    randomQuestions.add(allQuestions.get((r)));
                }
            }
        }
        return randomQuestions;
    }


}