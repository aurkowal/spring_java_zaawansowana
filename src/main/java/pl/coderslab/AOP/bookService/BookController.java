package pl.coderslab.AOP.bookService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book/{id}")
    public String book(@PathVariable long id) {
        bookService.findBookById(id);
        return "book";
    }

}
