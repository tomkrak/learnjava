package pl.sda.learnjava.LearnJava.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping
    public String home(Model model){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        if("anonymousUser".equals(name)) {
            name = "";
        }
        model.addAttribute("username", name);
        return "index";
    }
}
