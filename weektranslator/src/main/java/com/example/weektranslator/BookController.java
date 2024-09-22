package com.example.weektranslator;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    private List<Book> books = Arrays.asList(
            new Book(1L, "Mistborn", "Brandon Sanderson"),
            new Book(2L, "The Hobbit", "J.R.R. Tolkien"),
            new Book(3L, "Harry Potter", "J.K. Rowling")
    );

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable Long id) {
        Optional<Book> book = books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst();

        if (book.isPresent()) {
            return book.get();
        } else {
            throw new BookNotFoundException("Книга с id " + id + " не найдена");
        }
    }
}
