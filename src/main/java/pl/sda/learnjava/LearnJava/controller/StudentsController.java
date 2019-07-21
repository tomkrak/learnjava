package pl.sda.learnjava.LearnJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.learnjava.LearnJava.service.StudentService;
@Controller
@RequestMapping("/students")
public class StudentsController {
    private StudentService studentService;

    @Autowired
    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }
    @RequestMapping
    public String getStudents(Model model) {
        model.addAttribute("students", studentService.getStudents());
        return "students";
    }
}
