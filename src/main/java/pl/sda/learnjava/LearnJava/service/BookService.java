package pl.sda.learnjava.LearnJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.learnjava.LearnJava.dto.BookDTO;
import pl.sda.learnjava.LearnJava.model.Book;
import pl.sda.learnjava.LearnJava.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public void addBook(Book book) {
        bookRepository.save(book);
    }
    public boolean existByTitle(String title){
        return bookRepository.existsByTitle(title);
    }
    public List<BookDTO> getAllBooksAsDTO(){
        List<Book> all = bookRepository.findAll();
        List<BookDTO> bookDTOS= new ArrayList<>();
        for (Book b: all) {
            BookDTO bookDTO = new BookDTO();
            bookDTO.setTitle(b.getTitle());
            bookDTO.setAuthorName(b.getAuthorName());
            bookDTO.setCharacterization(b.getCharacterization());
            bookDTOS.add(bookDTO);

        }
        return bookDTOS;
    }


    public String getName(){
        return "Czcibor";
    }
}
