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

@Controller
@RequestMapping("/quiz")
public class QuizController {

    private QuestionService questionService;

    @Autowired
    public QuizController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping
    public String chooseLevel(Model model){
        List<String> questionsLevel = new ArrayList<>(questionService.getQuestionsLevel());
        List<String> parsingLevel = new ArrayList<>();

        int level = 0;
        for (int i = 0; i < questionsLevel.size(); i++) {
            if(questionsLevel.get(i).equals("1")){
                parsingLevel.add("Poziom początkujący");
            }
            else if(questionsLevel.get(i).equals("2")){
                parsingLevel.add("Poziom średniozaawansowany");
            }
            else if (questionsLevel.get(i).equals("3")){
                parsingLevel.add("Poziom zaawansowany");
            }
        }
        model.addAttribute("levels", parsingLevel);
        return "quiz";
    }

    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public String selectLevel(@RequestParam(name = "level") String level, Model model){
        List<Question> byLevel = null;
        if(level.equals("Poziom początkujący")){
            byLevel  = questionService.findByLevel(1);
        }
        else if(level.equals("Poziom średniozaawansowany")){
            questionService.findByLevel(2);
            byLevel  = questionService.findByLevel(2);
        }
        else if(level.equals("Poziom zaawansowany")){
            questionService.findByLevel(3);
            byLevel  = questionService.findByLevel(3);
        }
        questionService.getQuestionsLevel();
        model.addAttribute("questions",byLevel);
        return "/game";
    }
}
