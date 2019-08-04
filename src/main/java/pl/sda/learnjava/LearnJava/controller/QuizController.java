package pl.sda.learnjava.LearnJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import pl.sda.learnjava.LearnJava.service.QuestionService;
import pl.sda.learnjava.LearnJava.service.QuizAnswerDTOService;
import pl.sda.learnjava.LearnJava.service.StudentService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/quiz")
public class QuizController {

    private QuestionService questionService;
    private QuizAnswerDTOService quizAnswerDTOService;
    private StudentService studentService;


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
        List<Question> randomQuestions = questionService.findRandomFiveByLevel(levelInt);

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

        List<Question> questions = questionService.getQuestionsToCorrectQuiz(quizAnswerDTO);
        Student currentStudent = studentService.getByLogin(principal.getName());
        studentService.addScore(currentStudent, quizAnswerDTOService.getScore(quizAnswerDTO));
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
        questionService.clearAnsweredQuestions();

        return "redirect:/quiz";
    }


}
