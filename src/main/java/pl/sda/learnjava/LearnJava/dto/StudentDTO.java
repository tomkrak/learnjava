package pl.sda.learnjava.LearnJava.dto;

import pl.sda.learnjava.LearnJava.model.Student;

public class StudentDTO {

    private String name;
    private String lastName;
    private int level;
    private String login;
    private String password;

    public Student studentDtoToStudent() {
        return new Student(name, lastName, level, login, password);
    }
}
