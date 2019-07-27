package pl.sda.learnjava.LearnJava.model;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column
    private long id;
    @Column
    private  String name;
    @ManyToMany
    public Set<Student> students;

    public Role() {
    }


    public long getId() {
        return id;
    }


    public Role(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
