package pl.coderslab.AOP.bookService;

import org.springframework.stereotype.Service;

import java.awt.print.Book;

@Service
public class BookService {
    public Book findBookById(Long id) {

        return new Book();
    }
}
