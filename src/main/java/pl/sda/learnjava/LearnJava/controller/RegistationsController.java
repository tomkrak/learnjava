package pl.sda.learnjava.LearnJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sda.learnjava.LearnJava.dto.StudentDTO;
import pl.sda.learnjava.LearnJava.service.StudentService;

@Controller
@RequestMapping
public class RegistationsController {

    private StudentService studentService;

    @Autowired
    public RegistationsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/registrations")
    public String getRegistrations(Model model){
        StudentDTO studentDTO = new StudentDTO();
        model.addAttribute("studentDTO", studentDTO);
        return "registrations";
    }
    @RequestMapping(value = "/registrations", method = RequestMethod.POST)
    public String postRegistrations(@ModelAttribute StudentDTO studentDTO, Model model){
        studentService.addStudent(studentDTO);

        return "redirect:/students";
    }
}
