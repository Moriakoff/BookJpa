package moriakoff.bookjpa.controller;

import moriakoff.bookjpa.dao.Book;
import moriakoff.bookjpa.dao.BookId;
import moriakoff.bookjpa.model.BookModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookModel model;


    @GetMapping("/book")
    public Book getBook(@RequestParam String title,
                        @RequestParam String author) {
        return model.getBook(new BookId(title,author));
    }

    @PostMapping("/book")
    public boolean addBook(@RequestBody Book book){
        return model.add(book);
    }

    @DeleteMapping("/book")
    public Book deleteBook(@RequestBody BookId id) {
        return model.delete(id);
    }

    @PutMapping("/book")
    public Book updateBook(@RequestBody Book book){
        return model.update(book);
    }

    @GetMapping("/get_all")
    public List<Book> getAll(){
        return model.getAll();
    }

    @GetMapping("/get_all/publisher/{publisher}")
    public List<Book> getAllBooksByPublisher(@PathVariable String publisher){
        return model.getAllBooksByPublisher(publisher);
    }

    @GetMapping("get_all/author/{author}")
    public List <Book> getAllBooksByAuthor(@PathVariable String author) {
        return model.getAllBooksByAuthor(author);
    }

    @GetMapping("get_all/edition")
    public List <Book> getAllBooksBetweenEditon(
                                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
        return model.getAllBooksBetweenEdition(from, to);
    }

    @GetMapping("get_all/price")
    public List<Book> getAllBooksBetweenPrice(@RequestParam double from,
                                              @RequestParam double to){
        return model.getAllBooksBetweenPrice(from, to);
    }

    @PostMapping("/fill_repo")
    public List<Book> fillRepository(@RequestParam int amount){
        return model.fillRepository(amount);
    }

}
