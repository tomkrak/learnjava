package pl.sda.learnjava.LearnJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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

import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/quiz")
public class QuizController {

    private QuestionService questionService;
    private QuizAnswerDTOService quizAnswerDTOService;
    private StudentService studentService;

    @Autowired
    public QuizController(QuestionService questionService, QuizAnswerDTOService quizAnswerDTOService, StudentService studentService) {
        this.questionService = questionService;
        this.quizAnswerDTOService = quizAnswerDTOService;
        this.studentService = studentService;
    }

    @RequestMapping
    public String chooseLevel(Model model) {
        List<String> levels = new ArrayList<>(questionService.getQuestionsLevelAsMap().values());

        model.addAttribute("levels", levels);
        return "quiz";
    }

    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public String selectLevel(@RequestParam(name = "level") String level, Model model) {

        Integer levelInt = questionService.getQuestionsLevelAsMap()
                .entrySet()
                .stream()
                .filter(x -> level.equals(x.getValue()))
                .map(Map.Entry::getKey).findFirst()
                .get();
        List<Question> randomQuestions = questionService.findRandomFiveByLevel(levelInt);
        List<SimpleAnswer> simpleAnswers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SimpleAnswer simpleAnswer = new SimpleAnswer();
            simpleAnswer.setQuestion(randomQuestions.get(i).getName());
            simpleAnswers.add(simpleAnswer);
        }
        QuizAnswerDTO quizAnswerDTO = new QuizAnswerDTO();
        quizAnswerDTO.setSimpleAnswers(simpleAnswers);
        model.addAttribute("quizAnswerDTO", quizAnswerDTO);
        model.addAttribute("questions", randomQuestions);
        return "game";
    }

    @RequestMapping(value = "/game", method = RequestMethod.POST)
    public String submitQuiz(@ModelAttribute QuizAnswerDTO quizAnswerDTO, Model model, Principal principal) {

        List<Question> questions = new ArrayList<>();
        for (SimpleAnswer simpleAnswer : quizAnswerDTO.getSimpleAnswers()) {
            Question question = questionService.getByName(simpleAnswer.getQuestion());

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
        return "correctquiz";
    }
}
