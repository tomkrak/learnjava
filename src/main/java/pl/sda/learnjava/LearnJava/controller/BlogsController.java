package pl.sda.learnjava.LearnJava.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blogs")
public class BlogsController {
    @RequestMapping
    public String blogs(Model model){
        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
        return "blogs";

    }
}
