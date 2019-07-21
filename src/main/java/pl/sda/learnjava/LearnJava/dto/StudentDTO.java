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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
