package pl.sda.learnjava.LearnJava.model;

import com.sun.javafx.geom.transform.Identity;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column
    private long id;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private int level;

    @Column
    private String login;

    @Column
    private String password;


    public Student() {
    }

    public Student(String name, String lastName, int level, String login, String password) {
        this.name = name;
        this.lastName = lastName;
        this.level = level;
        this.login = login;
        this.password = password;
    }

    public Student(long id, String name, String lastName, int level, String login, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.level = level;
        this.login = login;
        this.password = password;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", level=" + level +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}