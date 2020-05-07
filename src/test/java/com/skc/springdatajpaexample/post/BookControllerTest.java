package com.skc.springdatajpaexample.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void getBook() throws Exception {
        Book book = new Book();
        book.setTitle("Spring Boot JPA");
        bookRepository.save(book);

        mockMvc.perform(get("/books/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("JPA")))
                .andExpect(content().string("Spring Boot JPA"));
    }

    @Test
    public void getBooks() throws Exception {
        Book book = new Book();
        book.setTitle("Spring Boot JPA");
        bookRepository.save(book);

        mockMvc.perform(get("/books")
                .param("page", "0")
                .param("size", "10")
                .param("sort", "created,desc")
                .param("sort", "title")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].title", containsString("JPA")));
    }

}