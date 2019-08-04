package pl.sda.learnjava.LearnJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.learnjava.LearnJava.dto.QuestionDTO;
import pl.sda.learnjava.LearnJava.dto.QuizAnswerDTO;
import pl.sda.learnjava.LearnJava.dto.SimpleAnswer;
import pl.sda.learnjava.LearnJava.model.Question;
import pl.sda.learnjava.LearnJava.repository.QuestionRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Service
public class QuestionService {
    private QuestionRepository questionRepository;
    @PersistenceContext
    EntityManager entityManager;
    private Set<Question> basicQuestionsAnswered = new HashSet<>();
    private Set<Question> mediumQuestionsAnswered = new HashSet<>();
    private Set<Question> advancedQuestionsAnswered = new HashSet<>();
    public Set<Question> getAnsweredQuestionsByLevel(int level) {
        if(level == 1)
            return this.basicQuestionsAnswered;
        if(level == 2)
            return this.mediumQuestionsAnswered;
        return this.advancedQuestionsAnswered;
    }



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

    public int getQuestionLevelasInt(String level) {
        Map<Integer, String> levelsMap = new HashMap<>();
        levelsMap.put(1, "Poziom początkujący");
        levelsMap.put(2, "Poziom średniozaawansowany");
        levelsMap.put(3, "Poziom zaawansowany");
        return levelsMap
                .entrySet()
                .stream()
                .filter(x -> level.equals(x.getValue()))
                .map(Map.Entry::getKey).findFirst()
                .get();
    }

    public List<Question> findByLevel(Integer level) {
        return questionRepository.findByLevel(level);
    }

    public Question getByName(String name) {
        return questionRepository.getByName(name);
    }

    public List<Question> findRandomFiveByLevel(Integer level) {
        Random random = new Random();
        List<Question> allQuestions = questionRepository.findByLevel(level);
        allQuestions.removeAll(getAnsweredQuestionsByLevel(level));
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
        getAnsweredQuestionsByLevel(level).addAll(randomQuestions);
        return randomQuestions;
    }
    public List<Question> getQuestionsToCorrectQuiz(QuizAnswerDTO quizAnswerDTO) {
        List<Question> questions = new ArrayList<>();


        for (SimpleAnswer simpleAnswer : quizAnswerDTO.getSimpleAnswers()) {
            Question question = questionRepository.getByName(simpleAnswer.getQuestion());
            entityManager.detach(question);

            if (question.getAnswer1().equals(simpleAnswer.getAnswer()) && !question.getAnswer1().equals(question.getCorrectAnswer())) {
                question.setAnswer1("<a style=\"color: red\">" + question.getAnswer1() + "</a>\n");
            }
            if (question.getAnswer2().equals(simpleAnswer.getAnswer()) && !question.getAnswer2().equals(question.getCorrectAnswer())) {
                question.setAnswer2("<a style=\"color: red\">" + question.getAnswer2() + "</a>\n");
            }
            if (question.getAnswer3().equals(simpleAnswer.getAnswer()) && !question.getAnswer3().equals(question.getCorrectAnswer())) {
                question.setAnswer3("<a style=\"color: red\">" + question.getAnswer3() + "</a>\n");
            }
            if (question.getAnswer4().equals(simpleAnswer.getAnswer()) && !question.getAnswer4().equals(question.getCorrectAnswer())) {
                question.setAnswer4("<a style=\"color: red\">" + question.getAnswer4() + "</a>\n");
            }

            if (question.getAnswer1().equals(question.getCorrectAnswer())) {
                question.setAnswer1("<a style=\"color: green\">" + question.getAnswer1() + "</a>\n");
            }
            if (question.getAnswer2().equals(question.getCorrectAnswer())) {
                question.setAnswer2("<a style=\"color: green\">" + question.getAnswer2() + "</a>\n");
            }
            if (question.getAnswer3().equals(question.getCorrectAnswer())) {
                question.setAnswer3("<a style=\"color: green\">" + question.getAnswer3() + "</a>\n");
            }
            if (question.getAnswer4().equals(question.getCorrectAnswer())) {
                question.setAnswer4("<a style=\"color: green\">" + question.getAnswer4() + "</a>\n");
            }

            questions.add(question);
        }
        return questions;
    }




     public void clearAnsweredQuestions() {
        basicQuestionsAnswered.clear();
        mediumQuestionsAnswered.clear();
        advancedQuestionsAnswered.clear();
     }
}