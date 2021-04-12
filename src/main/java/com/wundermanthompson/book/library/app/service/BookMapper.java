package com.wundermanthompson.book.library.app.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wundermanthompson.book.library.app.model.Book;
import com.wundermanthompson.book.library.app.model.Books;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/*
 * A class which serves a purpose of mapping JSONified class "Books.BookTemplate" to
 * a new class, which meets the requirements of the task (which is Book).
 */
@Service
public class BookMapper {
    public BookMapper() {
    }

    // Constructor to create a List of books from JSON file
    public static ArrayList<Book> getMappedBookList() {
        ArrayList<Book> bookList = new ArrayList<>();
        try {
            final ObjectMapper mapper = new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            final Books books = mapper.readValue(new URL("file:src/main/resources/static/json/books.json"), Books.class);

            for (Books.BookTemplate b : books.getItems()) {
                bookList.add(new Book(b));
            }
        } catch (IOException e) {
            return bookList;
        }
        return bookList;
    }
}
