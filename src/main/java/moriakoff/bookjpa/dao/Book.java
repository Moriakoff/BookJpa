package moriakoff.bookjpa.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(BookId.class)
public class Book {

    @Id
    String title;
    @Id
    String author;

    String publisher;

    LocalDate edition;

    double price;
}
