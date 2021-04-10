package com.wundermanthompson.book.library.app.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wundermanthompson.book.library.app.service.Book;
import com.wundermanthompson.book.library.app.service.BookMapper;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CategoriesController {
    public CategoriesController() {
    }

    /*
     * This endpoint serves a purpose of returning a list of books which are assigned to specific category.
     * User specifies by using an HTML form a category he's interested in, and this function returns a JSON
     * with a list of such books.
     */
    @RequestMapping(value = "/categories/{id}/books")
    public String getBooksForCategory(@RequestParam("id") @PathVariable String id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Book> bookList = BookMapper.getMappedBookList();
        for (Book b : bookList) {
            List<String> categoryListForBook = b.getCategories().stream()
                                                .map(String::toLowerCase)
                                                .collect(Collectors.toList());

            if (categoryListForBook.contains(id.toLowerCase())) {
                bookList.add(b);
            }
        }
        return mapper.writeValueAsString(bookList);
    }

    /*
     * Returns JSON with a category list, based on provided JSON book list.
     */
    @RequestMapping(value = "/categories")
    public String getCategoryList() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<String> categories = new ArrayList<>();

        for (Book b : BookMapper.getMappedBookList()) {
            if (b.getCategories().isEmpty()) {
                if (!categories.contains("UNCATEGORIZED")) {
                    categories.add("UNCATEGORIZED");
                }
            }
            else {
                for (String c : b.getCategories()) {
                    if (!categories.contains(c)) {
                        categories.add(c);
                    }
                }
            }
        }
        return mapper.writeValueAsString(categories);
    }
}
