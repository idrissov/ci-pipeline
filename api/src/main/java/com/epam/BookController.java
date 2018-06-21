package com.epam;

import java.util.HashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private HashMap<Integer, Book> bookHashMap = new HashMap<>();
    private int currentMaxVal = 0;

    public BookController() {
        Book book = new Book();
        book.setAuthor("Dan Braun");
        book.setName("Angels and Daemons");
        book.setId(getNextId());
        this.bookHashMap.put(book.getId(), book);
    }

    private int getNextId() {
        return currentMaxVal++;
    }

    @RequestMapping("/{id}")
    @GetMapping
    public Book getBook(@PathVariable("id") int id) {//Welcome page, non-rest
        return bookHashMap.get(id);
    }

    @RequestMapping("/")
    @PostMapping
    public int message(Book book) {
        book.setId(getNextId());

        bookHashMap.put(book.getId(), book);
        return book.getId();
    }

}
