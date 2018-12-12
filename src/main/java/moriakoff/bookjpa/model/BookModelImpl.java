package moriakoff.bookjpa.model;

import moriakoff.bookjpa.configuration.RandomConfig;
import moriakoff.bookjpa.dao.Book;
import moriakoff.bookjpa.dao.BookId;
import moriakoff.bookjpa.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookModelImpl implements BookModel {

    @Autowired
    BookRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Book getBook(BookId id) {
        return repository.findById(id).orElse(new Book());
    }

    @Override
    public boolean add(Book book) {
        if (repository.existsById(bookToID(book))) return false;
        repository.save(book);
        return true;
    }

    private BookId bookToID(Book book) {
        return new BookId(book.getTitle(), book.getAuthor());
    }

    @Override
    public Book delete(BookId id) {
        Book book = getBook(id);
        if(book != null) repository.deleteById(id);
        return book;
    }

    @Override
    public Book update(Book book) {
        return repository.save(book);
    }

    @Override
    public List <Book> addBooks(List <Book> books) {
        return repository.saveAll(books);
    }

    @Override
    @Transactional(readOnly = true)
    public List <Book> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List <Book> getAllBooksByPublisher(String publisher) {
        return repository.findBooksByPublisher(publisher);
    }

    @Override
    @Transactional(readOnly = true)
    public List <Book> getAllBooksByAuthor(String author) {
        return repository.findBooksByAuthor(author);
    }

    @Override
    @Transactional(readOnly = true)
    public List <Book> getAllBooksBetweenEdition(LocalDate from, LocalDate to) {
        return repository.findBooksByEditionBetween(from, to);
    }

    @Override
    @Transactional(readOnly = true)
    public List <Book> getAllBooksBetweenPrice(double from, double to) {
        return repository.findBooksByPriceBetween(from, to);
    }

    @Override
    public List <Book> fillRepository(int amount) {
        List <Book> books = new ArrayList <>();
        for (int i = 0; i < amount; i++) {
            books.add(RandomConfig.randomBook());
        }
        return repository.saveAll(books);
    }

    @Override
    public void deleteBooks(List <Book> books) {
        repository.deleteAll(books);
    }
}
