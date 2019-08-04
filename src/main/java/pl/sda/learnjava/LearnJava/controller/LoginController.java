package pl.sda.learnjava.LearnJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.learnjava.LearnJava.model.Question;
import pl.sda.learnjava.LearnJava.service.QuestionService;

@Controller
@RequestMapping("/login")
public class LoginController {
    QuestionService questionService;
    @Autowired
    public LoginController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping
    public String login(Model model){
        questionService.clearAnsweredQuestions();
        return "login";
    }
}
