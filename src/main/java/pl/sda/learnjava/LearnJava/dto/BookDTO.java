package pl.sda.learnjava.LearnJava.dto;

import pl.sda.learnjava.LearnJava.model.Book;

public class BookDTO {
    private String title;
    private String authorName;
    private String characterization;
    private int numberOfPages;
    private int year;

    public BookDTO(){

    }
    public Book bookDTOToBook() {
        return new Book(title,authorName,characterization,numberOfPages, year);
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

    public BookDTO(String title, String authorName, String characterization, int numberOfPages, int year) {
        this.title = title;
        this.authorName = authorName;
        this.characterization = characterization;
        this.numberOfPages = numberOfPages;
        this.year = year;
    }
}
