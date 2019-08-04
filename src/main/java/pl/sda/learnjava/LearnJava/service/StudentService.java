package pl.sda.learnjava.LearnJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.learnjava.LearnJava.dto.StudentDTO;
import pl.sda.learnjava.LearnJava.model.Role;
import pl.sda.learnjava.LearnJava.model.Student;
import pl.sda.learnjava.LearnJava.repository.RoleRepository;
import pl.sda.learnjava.LearnJava.repository.StudentRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    private RoleRepository roleRepository;

    public StudentService() {
    }

    @Autowired
    public StudentService(StudentRepository studentRepository, RoleRepository roleRepository) {
        this.studentRepository = studentRepository;
        this.roleRepository = roleRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(StudentDTO userDTO) {
        Student student = userDTO.studentDtoToStudent();
        Role role = roleRepository.getByName("student");
        student.setRoles(new HashSet<>(Arrays.asList(role)));
        studentRepository.save(student);
    }
    public void addStudent(Student student) {studentRepository.save(student);}

    public Student getByLogin(String login) {
        return studentRepository.getByLogin(login);
    }

    public void addScore(Student student, int score) {
        int level = student.getLevel();
        int progress = student.getProgress();
        student.setLevel(level + (progress + score)/10);
        student.setProgress((progress + score) % 10);
    }

}