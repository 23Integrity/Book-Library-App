package com.wundermanthompson.book.library.app.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wundermanthompson.book.library.app.api.exceptions.BookNotFoundException;
import com.wundermanthompson.book.library.app.model.Book;
import com.wundermanthompson.book.library.app.service.BookMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/*
 * Class which serves a purpose of finding first book with pages >= specified amount.
 * If no such book - throws a BookNotFoundException (which is 404)
 */
@RestController
public class BookVolumeController {
    private final ArrayList<Book> bookArrayList = BookMapper.getMappedBookList();

    // Basically searching in Book ArrayList for a book, that has pages >= specified value
    @RequestMapping(value = "/books")
    public String getFirstBookWithPages(@RequestParam (name="pages") int pages) throws JsonProcessingException {
        for (Book b : bookArrayList) {
            if (b.getPageCount() >= pages) {
                return new ObjectMapper().writeValueAsString(b);
            }
        }
        throw new BookNotFoundException();
    }
}
