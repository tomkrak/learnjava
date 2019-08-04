package pl.sda.learnjava.LearnJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.learnjava.LearnJava.dto.BookDTO;
import pl.sda.learnjava.LearnJava.service.BookService;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BooksController {
    @Autowired
     private BookService bookService ;

    @RequestMapping
    public String books(Model model){
        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
        List<BookDTO> allBooksAsDTO = bookService.getAllBooksAsDTO();
         String name= bookService.getName();
        System.out.println(allBooksAsDTO);
        model.addAttribute("books",allBooksAsDTO);
        return "books";


    }



}
