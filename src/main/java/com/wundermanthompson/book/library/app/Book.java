package com.wundermanthompson.book.library.app;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.ArrayList;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Book {
    public Book.volumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    private volumeInfo volumeInfo;

    static class volumeInfo {
        public String getTitle() {
            return title;
        }

        public ArrayList<String> getAuthors() {
            return authors;
        }

        public String getPublisher() {
            return publisher;
        }

        public String getPublishedDate() {
            return publishedDate;
        }

        public String getDescription() {
            return description;
        }

        public ArrayList<Book.volumeInfo.industryIdentifiers> getIndustryIdentifiers() {
            return industryIdentifiers;
        }

        public int getPageCount() {
            return pageCount;
        }

        public ArrayList<String> getCategories() {
            return categories;
        }

        public int getAverageRating() {
            return averageRating;
        }

        public int getRatingsCount() {
            return ratingsCount;
        }

        public String getMaturityRating() {
            return maturityRating;
        }

        public Book.volumeInfo.imageLinks getImageLinks() {
            return imageLinks;
        }

        public String getLanguage() {
            return language;
        }

        private String title;
        private ArrayList<String> authors;
        private String publisher;
        private String publishedDate;
        private String description;
        private ArrayList<industryIdentifiers> industryIdentifiers;
        private int pageCount;
        private ArrayList<String> categories;
        private int averageRating;
        private int ratingsCount;
        private String maturityRating;
        private imageLinks imageLinks;
        private String language;

        private static class industryIdentifiers {
            private String type;
            private String identifier;
        }
        private static class imageLinks {
            private String smallThumbnail;
            private String thumbnail;
        }
    }
}
