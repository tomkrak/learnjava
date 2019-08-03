package pl.sda.learnjava.LearnJava.dto;

import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.spring5.context.SpringContextUtils;
import pl.sda.learnjava.LearnJava.configuration.SpringContext;
import pl.sda.learnjava.LearnJava.model.Role;
import pl.sda.learnjava.LearnJava.model.Student;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class StudentDTO {

    @NotBlank(message = "Imię nie może być puste")
    private String name;
    private String lastName;
    private int level = 0;
    private String login;
    private String password;

    public Student studentDtoToStudent() {
        ApplicationContext applicationContext = SpringContext.getContext();
        PasswordEncoder passwordEncoder = applicationContext.getBean(PasswordEncoder.class);

        return new Student(name, lastName, login, passwordEncoder.encode(password));

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