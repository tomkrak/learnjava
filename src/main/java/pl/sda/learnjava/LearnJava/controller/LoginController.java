package pl.sda.learnjava.LearnJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    QuizController quizController;
    @Autowired
    public LoginController(QuizController quizController) {
        this.quizController = quizController;
    }

    @RequestMapping
    public String login(Model model){
        quizController.getAdvancedQuestionsAnswered().clear();
        quizController.getMediumQuestionsAnswered().clear();
        quizController.getBasicQuestionsAnswered().clear();
        return "login";
    }
}
