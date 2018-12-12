package moriakoff.bookjpa;

import moriakoff.bookjpa.dao.Book;
import moriakoff.bookjpa.model.BookModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookModelImplTest {


    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private List <Book> books;

    @Autowired
    private BookModel model;


    @BeforeEach
    void setUp() {
        book1 = new Book("TestTitle1", "TestAuthor1", "TestPublisher",
                LocalDate.of(1900, 1, 1), 10.);
        book2 = new Book("TestTitle2", "TestAuthor2", "TestPublisher",
                LocalDate.of(1900, 12, 31), 20.);
        book3 = new Book("TestTitle3", "TestAuthor3", "TestPublisher",
                LocalDate.of(1900, 2, 27), 30.);
        book4 = new Book("TestTitle4", "TestAuthor4", "TestPublisher",
                LocalDate.of(1900, 1, 5), 40.);
        books = new ArrayList <>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
    }

    @AfterEach
    void tearDown() {
        model.deleteBooks(books);
    }

    @Test
    void getBook() {

    }

    @Test
    void add() {
        assertTrue(model.add(book1));
        assertFalse(model.add(book1));
    }

    @Test
    void delete() {
        assertTrue(model.add(book1));
        assertEquals(book1, book1);
    }

    @Test
    void update() {
        assertTrue(model.add(book1));
        Book testBook = new Book(book1.getTitle(), book1.getAuthor(), "te", LocalDate.now(), 100.);
        assertNotEquals(book1, model.update(testBook));
    }

    @Test
    void getAll() {
        assertTrue(model.addBooks(books).containsAll(books));
    }

    @Test
    void getAllBooksByPublisher() {
        model.addBooks(books);
        assertEquals(4, model.getAllBooksByPublisher("TestPublisher").size());
    }

    @Test
    void getAllBooksByAuthor() {
        model.addBooks(books);
        assertEquals(1, model.getAllBooksByAuthor("TestAuthor1").size());
    }

    @Test
    void getAllBooksBetweenEdition() {
        model.addBooks(books);
        assertEquals(3, model.getAllBooksBetweenEdition(LocalDate.of(1900, 1, 1),
                LocalDate.of(1900, 11, 11)).size());

    }

    @Test
    void getAllBooksBetweenPrice() {
        model.addBooks(books);
        assertEquals(3, model.getAllBooksBetweenPrice(9., 31.).size());
    }
}