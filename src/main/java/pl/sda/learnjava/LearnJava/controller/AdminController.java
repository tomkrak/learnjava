package pl.sda.learnjava.LearnJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sda.learnjava.LearnJava.dto.QuestionDTO;
import pl.sda.learnjava.LearnJava.service.QuestionService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private QuestionService questionService;

    @Autowired
    public AdminController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping("/addquestion")
    public String addQuestion(Model model) {
        model.addAttribute("questionDTO", new QuestionDTO());
        return "addquestion";
    }

    @RequestMapping(value = "/addquestion", method = RequestMethod.POST)
    public String postAddQuestion(@ModelAttribute QuestionDTO questionDTO, Model model) {

        questionService.addQuestion(questionDTO);
        return "redirect:/questions";
    }
}
