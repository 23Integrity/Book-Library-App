package com.michalwesoly.book.library.app.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.michalwesoly.book.library.app.service.BookMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Controller for returning all books
 */
@RestController
public class AllBooksController {
    @RequestMapping (value = "/all-books")
    public String getAllBooks() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(BookMapper.getMappedBookList());
    }
}
