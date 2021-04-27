package com.michalwesoly.book.library.app.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.michalwesoly.book.library.app.model.Book;
import com.michalwesoly.book.library.app.service.BookMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;

/*
 * Class that responds with top author list;
 * It creates an author list based on provided JSON, then calculates their rating
 * basing on all their books in JSON, then sorts them in descending order.
 * Such list is then returned stringified to client.
 */
@RestController
public class RatingController {
    // Endpoint for returning a sorted list of top authors
    @RequestMapping(value = "/top-authors")
    public String getTopAuthorsList() throws JsonProcessingException {
        ArrayList<String> topAuthorsNameList = new ArrayList<>();
        ArrayList<Author> topAuthorsList = new ArrayList<>();
        ArrayList<Book> bookList = BookMapper.getMappedBookList();

        // in a list of all books, find all authors
        // and add them to their names' list - because we look for String which is their name
        // - if the list doesn't contain their name already. And if it doesn't, it creates a new Author
        // in topAuthorsList. Then it gets sorted and returned
        for (Book b : bookList) {
            if (b.getAverageRating() > 0) {
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

    // Author class for managing the output string
    // It bases mainly on its two attributes: author (which is author's name) and averageRating
    // On declaration it calculates author's averageRating basing on provided JSON.
    // Implements Comparable in order to use Collections.sort() method.
    private static class Author implements Comparable<Author> {
        Author(String authorName) {
            author = authorName;
            this.averageRating = calculateAverageRating();
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
        private double calculateAverageRating() {
            ArrayList<Book> books = BookMapper.getMappedBookList();
            ArrayList<Book> authorBooks = new ArrayList<>();
            ArrayList<Double> ratings = new ArrayList<>();
            double averageRating = 0;

            // Finding specific author's books
            for (Book b : books) {
                if (b.getAuthors().contains(author)) {
                    authorBooks.add(b);
                }
            }
            // Getting all their ratings into an array
            for (Book b : authorBooks) {
                if (b.getAverageRating() > 0)
                    ratings.add(b.getAverageRating());
            }
            // Summing all the ratings into double variable
            for (Double r : ratings) {
                averageRating += r;
            }
            // returning the average: rating sum / amount of ratings
            if (ratings.size() > 0)
                return averageRating / ratings.size();
            return 0;
        }

        private final String author;
        private final double averageRating;
    }
}
