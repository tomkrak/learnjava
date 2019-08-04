package pl.sda.learnjava.LearnJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sda.learnjava.LearnJava.dto.BookDTO;
import pl.sda.learnjava.LearnJava.dto.QuestionDTO;
import pl.sda.learnjava.LearnJava.service.BookService;
import pl.sda.learnjava.LearnJava.service.QuestionService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private QuestionService questionService;
    private BookService bookService;

    @Autowired
    public AdminController(QuestionService questionService, BookService bookService) {
        this.questionService = questionService;
        this.bookService = bookService;
    }

    @RequestMapping("/addquestion")
    public String addQuestion(Model model) {
        model.addAttribute("questionDTO", new QuestionDTO());
        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
        return "addquestion";
    }

    @RequestMapping(value = "/addquestion", method = RequestMethod.POST)
    public String postAddQuestion(@ModelAttribute QuestionDTO questionDTO, Model model) {

        questionService.addQuestion(questionDTO);
        return "redirect:/questions";
    }

    @RequestMapping("/addbooks")
    public String addBooks(Model model) {
        model.addAttribute("bookDTO", new BookDTO());
        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
        return "addbooks";
    }
    @RequestMapping(value = "/addbooks",method = RequestMethod.POST)
    public String postAddBook(@ModelAttribute BookDTO bookDTO,Model model){
        bookService.addBook(bookDTO.bookDTOToBook());
        return "redirect:/admin/addbooks";
    }

}

