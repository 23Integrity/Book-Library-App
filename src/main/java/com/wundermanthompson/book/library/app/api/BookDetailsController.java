package com.wundermanthompson.book.library.app.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wundermanthompson.book.library.app.api.exceptions.WrongIdException;
import com.wundermanthompson.book.library.app.model.Book;
import com.wundermanthompson.book.library.app.service.BookMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/*
 * Class for responding the details of specified book.
 * Throws WrongIdException (which corresponds to 500 HTTP response) if book with specified isbn
 * isn't present in current book-set (so assuming user entered wrong id)
 */
@RestController
public class BookDetailsController {
    private final ArrayList<Book> books = BookMapper.getMappedBookList();

    // Returning a stringified Book object containing all the details of searched book;
    // If there's no book with such id - throws 404
    @RequestMapping(value = "/details")
    public String getBookDetails(@RequestParam(name="isbn") String id) throws JsonProcessingException {
        for (Book b : books) {
            if (b.getIsbn().equals(id)) {
                return new ObjectMapper().writeValueAsString(b);
            }
        }
        throw new WrongIdException();
    }
}
