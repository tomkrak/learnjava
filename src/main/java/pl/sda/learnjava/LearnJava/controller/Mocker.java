package pl.sda.learnjava.LearnJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.sda.learnjava.LearnJava.model.Question;
import pl.sda.learnjava.LearnJava.model.Student;
import pl.sda.learnjava.LearnJava.repository.QuestionRepository;
import pl.sda.learnjava.LearnJava.repository.StudentRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Mocker {
    private StudentRepository studentRepository;
    private QuestionRepository questionRepository;

    @Autowired
    public Mocker(StudentRepository studentRepository, QuestionRepository questionRepository) {
        this.studentRepository = studentRepository;
        this.questionRepository = questionRepository;
    }

    @PostConstruct
    public void mockData() {


        Student student = new Student();

        student.setLogin("kowalski");
        student.setPassword("kowalski1");
        student.setName("andrzej");
        student.setLastName("kowalski");
        student.setLevel(1);

        Student student1 = new Student();
        student1.setLevel(2);
        student1.setLogin("nowak");
        student1.setPassword("haslo2");
        student1.setName("Stefan");
        student1.setLastName("Nowak");

        studentRepository.save(student);
        studentRepository.save(student1);

        Question question = new Question("question1");
        question.setAnswer1("answer1");
        question.setAnswer2("answer2");
        question.setAnswer3("answer3");
        question.setCorrectAnswer("correct");
        question.setLevel(1);

        Question question1 = new Question("question2");
        question1.setLevel(2);
        question1.setAnswer1("answer1");
        question1.setAnswer2("answer2");
        question1.setAnswer3("answer3");
        question1.setCorrectAnswer("correct");


        questionRepository.save(question);
        questionRepository.save(question1);
    }
}
