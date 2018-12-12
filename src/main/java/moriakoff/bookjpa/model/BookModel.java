package moriakoff.bookjpa.model;

import moriakoff.bookjpa.dao.Book;
import moriakoff.bookjpa.dao.BookId;

import java.time.LocalDate;
import java.util.List;

public interface BookModel {

    Book getBook(BookId id);

    boolean add(Book book);

    Book delete(BookId id);

    Book update(Book book);

    List <Book> addBooks(List <Book> books);

    List <Book> getAll();

    List <Book> getAllBooksByPublisher(String publisher);

    List <Book> getAllBooksByAuthor(String author);

    List <Book> getAllBooksBetweenEdition(LocalDate from, LocalDate to);

    List <Book> getAllBooksBetweenPrice(double from, double to);

    List <Book> fillRepository(int amount);

    void deleteBooks(List<Book> books);





}
