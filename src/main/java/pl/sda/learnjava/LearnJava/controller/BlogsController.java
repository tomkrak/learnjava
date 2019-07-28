package pl.sda.learnjava.LearnJava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blogs")
public class BlogsController {
    @RequestMapping
    public String blogs(Model model){
        return "blogs";

    }
}
