package com.wundermanthompson.book.library.app;

import java.nio.file.Path;

public class Book {
    public String getISBN_13() {
        return ISBN_13;
    }

    public String getISBN_10() {
        return ISBN_10;
    }

    public void setISBN(String ISBN_13) {
        this.ISBN_13 = ISBN_13;
        this.ISBN_10 = ISBN_13.substring(2, 12);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Path getSmall_thumbnail() {
        return small_thumbnail;
    }

    public void setSmall_thumbnail(Path small_thumbnail) {
        this.small_thumbnail = small_thumbnail;
    }

    public Path getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Path thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Path getGoogle_link() {
        return google_link;
    }

    public void setGoogle_link(Path google_link) {
        this.google_link = google_link;
    }

    private String ISBN_13;
    private String ISBN_10;
    private String title;
    private String author;
    private String publisher;
    private String language;
    private Path small_thumbnail;
    private Path thumbnail;
    private Path google_link;

    Book(String ISBN_13, String title, String author, String publisher, String language,
         Path small_thumbnail, Path thumbnail, Path google_link) {
        this.ISBN_13 = ISBN_13;
        this.ISBN_10 = ISBN_13.substring(3, 12);
        this.title = author;
        this.publisher = publisher;
        this.language = language;
        this.small_thumbnail = small_thumbnail;
        this.thumbnail = thumbnail;
        this.google_link = google_link;
    }
}
