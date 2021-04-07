package com.wundermanthompson.book.library.app;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;


public class CategoriesController {
    ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    BooksTemplate books = mapper.readValue(new URL("file:src/main/resources/static/json/books.json"), BooksTemplate.class);

    public CategoriesController() throws IOException {
    }

    @GetMapping("/get-books-for-category")
    @ResponseBody
    public Book getBooksForCategory(@RequestParam(name="category") String name) {
        for (Book i : books.getItems()) {
            for (String category : i.getVolumeInfo().getCategories()) {
                if (category.equals(name)) {
                    return i;
                }
            }
        }
        return null;
    }
    @GetMapping("/get-categories")
    @ResponseBody
    public ArrayList<String> getCategories() {
        ArrayList<String> categoryList = new ArrayList<>();
        for (Book i : books.getItems()) {
            for (String category : i.getVolumeInfo().getCategories()) {
                if (!categoryList.contains(category)) {
                    categoryList.add(category);
                }
            }
        }
        return categoryList;
    }
}
