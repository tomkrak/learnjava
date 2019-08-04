package pl.sda.learnjava.LearnJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.learnjava.LearnJava.model.Book;

public interface BookRepository  extends JpaRepository<Book, Long> {

}
