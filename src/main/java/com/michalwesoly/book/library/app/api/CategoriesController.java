package com.michalwesoly.book.library.app.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.michalwesoly.book.library.app.model.Book;
import com.michalwesoly.book.library.app.service.BookMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


/*
 * This class serves a purpose of returning a list of books which are assigned to specific category.
 * User specifies by using an HTML form a category he's interested in, and this function returns a JSON
 * with a list of such books.
 */
@RestController
public class CategoriesController {

    // Case-independent search for books in specified category
    // Returns a stringified list of books that correspond to the category
    // Can return an empty list, so it has to be managed from the front to not display an empty page
    @RequestMapping(value = "/categories/books")
    public String getBooksForCategory(@RequestParam("id") String id) throws JsonProcessingException {
        ArrayList<Book> bookList = BookMapper.getMappedBookList();
        ArrayList<Book> booksToReturn = new ArrayList<>();
        for (Book b : bookList) {
            // Mapping categories to all lowercase to standardize the search value;
            // So doesn't matter if user is going to look for "java", "Java", "jAvA" or other pokemon name,
            // he's going to get a category he was looking for (using the endpoint directly)
            ArrayList<String> categoryListForBook = b.getCategories();
            categoryListForBook.replaceAll(String::toLowerCase);

            if (categoryListForBook.contains(id.toLowerCase())) { booksToReturn.add(b); }
        }
        return new ObjectMapper().writeValueAsString(booksToReturn);
    }

    // Returns JSON with a category list.
    @RequestMapping(value = "/categories")
    public String getCategoryList() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<String> categories = new ArrayList<>();

        // In a list of all books, check if book's categories aren't empty.
        // If they aren't, add them to categories list
        for (Book b : BookMapper.getMappedBookList()) {
            if (!b.getCategories().isEmpty()) {
                for (String c : b.getCategories()) {
                    if (!categories.contains(c)) {
                        categories.add(c);
                    }
                }
            }
        }

        // Sort alphabetically
        Collections.sort(categories);
        return mapper.writeValueAsString(categories);
    }
}
