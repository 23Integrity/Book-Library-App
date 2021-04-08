package com.wundermanthompson.book.library.app.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wundermanthompson.book.library.app.model.Books;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;

@RestController
public class SearchController {
    private final ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    private final Books books = mapper.readValue(new URL("file:src/main/resources/static/json/books.json"), Books.class);

    public SearchController() throws IOException { }

    @RequestMapping(value = "/get-book-details")
    public String getBookDetails(@RequestParam(name="isbn") String id) throws JsonProcessingException {
        if (!id.isEmpty()) {
            for (Books.Book b : books.getItems()) {
                for (Books.Book.volumeInfo.IndustryIdentifiers i : b.getVolumeInfo().getIndustryIdentifiers()) {
                    if (i.getIdentifier().equals(id)) {
                        return mapper.writeValueAsString(b);
                    }
                }
            }
        }
        throw new BookExceptions.WrongID();
    }
}
