package com.wundermanthompson.book.library.app.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wundermanthompson.book.library.app.service.Book;
import com.wundermanthompson.book.library.app.service.BookMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;

@RestController
public class RatingController {
    @RequestMapping(value = "/get-top-authors")
    public String getTopAuthorsList() throws JsonProcessingException {
        ArrayList<String> topAuthorsNameList = new ArrayList<>();
        ArrayList<Author> topAuthorsList = new ArrayList<>();
        ArrayList<Book> bookList = BookMapper.getMappedBookList();

        for (Book b : bookList) {
            if (!b.getAuthors().isEmpty()) {
                for (String a : b.getAuthors()) {
                    if (!topAuthorsNameList.contains(a)) {
                        topAuthorsNameList.add(a);
                        topAuthorsList.add(new Author(a));
                    }
                }
            }
        }
        topAuthorsList.sort(Comparator.reverseOrder());
        return new ObjectMapper().writeValueAsString(topAuthorsList);
    }

    private static class Author implements Comparable<Author> {
        Author(String authorName) {
            author = authorName;
            calculateAverageRating();
        }

        public String getAuthor() {
            return author;
        }
        public double getAverageRating() {
            return averageRating;
        }

        @Override
        public int compareTo(Author a1) {
            if (this.getAverageRating() < a1.getAverageRating()) {
                return -1;
            }
            else if (this.getAverageRating() == a1.getAverageRating()) {
                return 0;
            }
            return 1;
        }

        // For some reason, works only for authors with only 1 book
        private void calculateAverageRating() {
            ArrayList<Book> books = BookMapper.getMappedBookList();
            ArrayList<Book> authorBooks = new ArrayList<>();
            ArrayList<Double> ratings = new ArrayList<>();
            double averageRating = 0;

            // Finding specific author's books
            for (Book b : books) {
                if (b.getAuthors().contains(this.author)) {
                    authorBooks.add(b);
                }
            }
            // Getting all their ratings into an array
            for (Book b : authorBooks) {
                ratings.add(b.getAverageRating());
            }
            // Summing all the ratings into double variable
            for (Double r : ratings) {
                averageRating += r;
            }
            // returning the average: rating sum / amount of ratings
            this.averageRating = averageRating / ratings.size();
        }

        private final String author;
        private double averageRating = 0;
    }
}
