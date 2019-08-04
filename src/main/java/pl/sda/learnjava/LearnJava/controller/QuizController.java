package pl.sda.learnjava.LearnJava.controller;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.learnjava.LearnJava.dto.QuizAnswerDTO;
import pl.sda.learnjava.LearnJava.dto.SimpleAnswer;
import pl.sda.learnjava.LearnJava.model.Question;
import pl.sda.learnjava.LearnJava.model.Student;
import pl.sda.learnjava.LearnJava.repository.QuestionRepository;
import pl.sda.learnjava.LearnJava.service.QuestionService;
import pl.sda.learnjava.LearnJava.service.QuizAnswerDTOService;
import pl.sda.learnjava.LearnJava.service.StudentService;
import sun.plugin.liveconnect.SecurityContextHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/quiz")
public class QuizController {

    private QuestionService questionService;
    private QuizAnswerDTOService quizAnswerDTOService;
    private StudentService studentService;
    private Set<Question> basicQuestionsAnswered = new HashSet<>();
    private Set<Question> mediumQuestionsAnswered = new HashSet<>();
    private Set<Question> advancedQuestionsAnswered = new HashSet<>();

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    public QuizController(QuestionService questionService, QuizAnswerDTOService quizAnswerDTOService, StudentService studentService) {
        this.questionService = questionService;
        this.quizAnswerDTOService = quizAnswerDTOService;
        this.studentService = studentService;
    }

    @RequestMapping
    public String chooseLevel(Model model) {
        List<String> levels = new ArrayList<>(questionService.getQuestionsLevelAsMap().values());
        Authentication autentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("levels", levels);
        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
        return "quiz";
    }

    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public String selectLevel(@RequestParam(name = "level") String level, Model model) {

        int levelInt = questionService.getQuestionLevelasInt(level);
        List<Question> randomQuestions = new ArrayList<>();
        switch (levelInt) {
            case 1:
                randomQuestions = questionService.findRandomFiveByLevel(levelInt, basicQuestionsAnswered);
                if (randomQuestions.size() == 5)
                    basicQuestionsAnswered.addAll(randomQuestions);


                break;
            case 2:
                randomQuestions = questionService.findRandomFiveByLevel(levelInt, mediumQuestionsAnswered);
                if (randomQuestions.size() == 5)
                    mediumQuestionsAnswered.addAll(randomQuestions);

                break;
            case 3:
                randomQuestions = questionService.findRandomFiveByLevel(levelInt, advancedQuestionsAnswered);
                if (randomQuestions.size() == 5)
                    advancedQuestionsAnswered.addAll(randomQuestions);
                break;

        }
        List<SimpleAnswer> simpleAnswers = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            SimpleAnswer simpleAnswer = new SimpleAnswer();
            if (randomQuestions.size() == 5)
                simpleAnswer.setQuestion(randomQuestions.get(i).getName());
            simpleAnswers.add(simpleAnswer);

        }
        QuizAnswerDTO quizAnswerDTO = new QuizAnswerDTO();
        quizAnswerDTO.setSimpleAnswers(simpleAnswers);
        model.addAttribute("quizAnswerDTO", quizAnswerDTO);
        model.addAttribute("questions", randomQuestions);
        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
        return "game";
    }

    @RequestMapping(value = "/game", method = RequestMethod.POST)
    public String submitQuiz(@ModelAttribute QuizAnswerDTO quizAnswerDTO, Model model, Principal principal) {

        List<Question> questions = new ArrayList<>();


        for (SimpleAnswer simpleAnswer : quizAnswerDTO.getSimpleAnswers()) {
            Question question = questionService.getByName(simpleAnswer.getQuestion());
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
        Student currentStudent = studentService.getByLogin(principal.getName());
        currentStudent.addScore(quizAnswerDTOService.getScore(quizAnswerDTO));
        studentService.addStudent(currentStudent);
        model.addAttribute("quizScore", quizAnswerDTOService.getScore(quizAnswerDTO));
        model.addAttribute("level", currentStudent.getLevel());
        model.addAttribute("progressLeft", 10 - currentStudent.getProgress());
        model.addAttribute("questions", questions);
        List<String> levels = new ArrayList<>(questionService.getQuestionsLevelAsMap().values());
        model.addAttribute("levels", levels);
        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
        return "correctquiz";
    }

    @RequestMapping(value = "/newgame", method = RequestMethod.POST)
    public String newGame() {
        basicQuestionsAnswered.clear();
        mediumQuestionsAnswered.clear();
        advancedQuestionsAnswered.clear();
        return "redirect:/quiz";
    }

    public Set<Question> getBasicQuestionsAnswered() {
        return basicQuestionsAnswered;
    }

    public void setBasicQuestionsAnswered(Set<Question> basicQuestionsAnswered) {
        this.basicQuestionsAnswered = basicQuestionsAnswered;
    }

    public Set<Question> getMediumQuestionsAnswered() {
        return mediumQuestionsAnswered;
    }

    public void setMediumQuestionsAnswered(Set<Question> mediumQuestionsAnswered) {
        this.mediumQuestionsAnswered = mediumQuestionsAnswered;
    }

    public Set<Question> getAdvancedQuestionsAnswered() {
        return advancedQuestionsAnswered;
    }

    public void setAdvancedQuestionsAnswered(Set<Question> advancedQuestionsAnswered) {
        this.advancedQuestionsAnswered = advancedQuestionsAnswered;
    }
}
