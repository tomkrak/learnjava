package pl.sda.learnjava.LearnJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {

    public MenuController(){

    }
    @RequestMapping
    public String menu(){
        return "index";




    }

}
