package pl.sda.learnjava.LearnJava.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BooksController {
    @RequestMapping
    public String books(Model model){
        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
        return "books";
    }


}
