package pl.sda.learnjava.LearnJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
        model.addAttribute("questions", questionService.findRandomFiveByLevel(levelInt));
        return "/game";
    }
}
