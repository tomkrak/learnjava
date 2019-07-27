package pl.sda.learnjava.LearnJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.learnjava.LearnJava.service.QuestionService;

@Controller
@RequestMapping("/questions")
public class QuestionsController {

    private QuestionService questionService;

    @Autowired
    public QuestionsController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping
    public String getQuestions(Model model) {
        model.addAttribute("questions", questionService.getQuestions());
        return "questions";
    }
}
