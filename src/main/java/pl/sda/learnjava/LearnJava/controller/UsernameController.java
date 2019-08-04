package pl.sda.learnjava.LearnJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.learnjava.LearnJava.model.Student;
import pl.sda.learnjava.LearnJava.service.StudentService;

import java.security.Principal;

@Controller
@RequestMapping("/username")
public class UsernameController {
    StudentService studentService;
    @Autowired
    public UsernameController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping
    public String userName(Model model, Principal principal) {
        Student currentStudent = studentService.getByLogin(principal.getName());
        studentService.addStudent(currentStudent);
        model.addAttribute("name", currentStudent.getName());
        model.addAttribute("lastName", currentStudent.getLastName());
        model.addAttribute("level", currentStudent.getLevel());
        model.addAttribute("progressLeft", 10 - currentStudent.getProgress());
        return "username";
    }
}
