package pl.sda.learnjava.LearnJava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BooksController {
    @RequestMapping
    public String books(Model model){
        return "books";
    }


}
