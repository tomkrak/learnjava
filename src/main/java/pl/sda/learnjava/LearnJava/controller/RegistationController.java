package pl.sda.learnjava.LearnJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sda.learnjava.LearnJava.dto.StudentDTO;
import pl.sda.learnjava.LearnJava.service.StudentService;

import javax.validation.Valid;

@Controller
@RequestMapping
public class RegistationController {

    private StudentService studentService;

    @Autowired
    public RegistationController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/registration")
    public String getRegistrations(Model model) {
        StudentDTO studentDTO = new StudentDTO();
        model.addAttribute("studentDTO", studentDTO);
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String postRegistrations(@ModelAttribute @Valid StudentDTO studentDTO, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        } else {
            studentService.addStudent(studentDTO);
            return "redirect:/login";
        }
    }
}