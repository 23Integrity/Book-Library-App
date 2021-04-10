package com.wundermanthompson.book.library.app.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wundermanthompson.book.library.app.api.exceptions.BookNotFoundException;
import com.wundermanthompson.book.library.app.service.Book;
import com.wundermanthompson.book.library.app.service.BookMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class BookVolumeController {
    private final ArrayList<Book> bookArrayList = BookMapper.getMappedBookList();

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
