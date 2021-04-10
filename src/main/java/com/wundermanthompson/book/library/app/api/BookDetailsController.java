package com.wundermanthompson.book.library.app.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wundermanthompson.book.library.app.api.exceptions.BookExceptions;
import com.wundermanthompson.book.library.app.model.Books;
import com.wundermanthompson.book.library.app.service.Book;
import com.wundermanthompson.book.library.app.service.BookMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

@RestController
public class BookDetailsController {
    private final ArrayList<Book> books = BookMapper.getMappedBookList();

    // Returning a Book object containing all the details of searched book;
    // If there's no book with such id - throws 404
    @RequestMapping(value = "/details")
    public String getBookDetails(@RequestParam(name="isbn") String id) throws JsonProcessingException {
        for (Book b : books) {
            if (b.getIsbn().equals(id)) {
                return new ObjectMapper().writeValueAsString(b);
            }
        }
        throw new BookExceptions.WrongID();
    }
    @RequestMapping(value = "/all-books")
    public String getAllBooks() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(books);
    }
    @RequestMapping(value ="/get-json")
    public String getJson() throws IOException {
        final ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final Books books = mapper.readValue(new URL("file:src/main/resources/static/json/books.json"), Books.class);
        return mapper.writeValueAsString(books);
    }
}
