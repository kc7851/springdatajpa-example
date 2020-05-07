package com.skc.springdatajpaexample.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books/{id}")
    public String getBook(@PathVariable("id") Book book) {
        return book.getTitle();
    }

    @GetMapping("/books")
    public Page<Book> getBoos(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

}
