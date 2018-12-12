package moriakoff.bookjpa.repository;

import moriakoff.bookjpa.dao.Book;
import moriakoff.bookjpa.dao.BookId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, BookId> {

    List <Book> findBooksByAuthor(String author);

    List <Book> findBooksByPublisher(String publisher);

    List<Book> findBooksByEditionBetween(LocalDate from, LocalDate to);

    List <Book> findBooksByPriceBetween(double from, double to);

}
