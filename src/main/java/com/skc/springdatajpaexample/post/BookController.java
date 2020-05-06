package com.skc.springdatajpaexample.post;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @GetMapping("/books/{id}")
    public String getBook(@PathVariable("id") Book book) {
        return book.getTitle();
    }

}
