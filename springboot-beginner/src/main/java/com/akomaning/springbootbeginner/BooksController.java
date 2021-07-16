package com.akomaning.springbootbeginner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BooksController {
    @GetMapping("books")
    List<Book> getAllBooks() {
        return Arrays.asList(new Book(1, "Mastering spring boot", "Emmanuel"));

    }





}
