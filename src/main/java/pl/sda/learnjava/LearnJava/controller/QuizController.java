package pl.sda.learnjava.LearnJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.learnjava.LearnJava.dto.QuizAnswerDTO;
import pl.sda.learnjava.LearnJava.dto.SimpleAnswer;
import pl.sda.learnjava.LearnJava.model.Question;
import pl.sda.learnjava.LearnJava.repository.QuestionRepository;
import pl.sda.learnjava.LearnJava.service.QuestionService;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/quiz")
public class QuizController {

    private QuestionService questionService;

    @Autowired
    public QuizController(QuestionService questionService) {
        this.questionService = questionService;
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
        for(int i = 0; i < 5; i++) {
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
    public String submitQuiz(@ModelAttribute QuizAnswerDTO quizAnswerDTO, Model model) {
        System.out.println(quizAnswerDTO);
        return "redirect:/quiz";
    }
}
