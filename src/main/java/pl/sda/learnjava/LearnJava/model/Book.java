package pl.sda.learnjava.LearnJava.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    long id;

    @Column
    String title;

    @Column
    String authorName;

    @Column
    String characterization;

    @Column
    int numberOfPages;

    @Column
    int year;

    public long getId() {
        return id;
    }

    public Book(){

    }


    public Book(String title, String authorName, String characterization, int numberOfPages, int year) {
        this.title = title;
        this.authorName = authorName;
        this.characterization = characterization;
        this.numberOfPages = numberOfPages;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCharacterization() {
        return characterization;
    }

    public void setCharacterization(String characterization) {
        this.characterization = characterization;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                ", characterization='" + characterization + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", year=" + year +
                '}';
    }
}
