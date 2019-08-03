package pl.sda.learnjava.LearnJava.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column
    private Long id;
    private String name;
    private String text;
    private int level;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String correctAnswer;

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", level=" + level +
                ", answer1='" + answer1 + '\'' +
                ", answer2='" + answer2 + '\'' +
                ", answer3='" + answer3 + '\'' +
                ", answer4='" + answer4 + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLevel() {
        return level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Question() {
    }

    public Question(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public Question(String name, String text, int level, String answer1, String answer2, String answer3, String answer4, String correctAnswer) {
        this.name = name;
        this.text = text;
        this.level = level;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return level == question.level &&
                id.equals(question.id) &&
                Objects.equals(name, question.name) &&
                Objects.equals(text, question.text) &&
                Objects.equals(answer1, question.answer1) &&
                Objects.equals(answer2, question.answer2) &&
                Objects.equals(answer3, question.answer3) &&
                Objects.equals(answer4, question.answer4) &&
                Objects.equals(correctAnswer, question.correctAnswer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}