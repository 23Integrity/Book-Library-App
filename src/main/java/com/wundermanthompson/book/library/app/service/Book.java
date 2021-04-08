package com.wundermanthompson.book.library.app.service;

import com.wundermanthompson.book.library.app.model.Books;

import java.util.ArrayList;

public class Book {
    Book(Books.Book b) {
        // setting proper ISBN - if type is other than ISBN_13, then it uses book's id
        for (Books.Book.volumeInfo.IndustryIdentifiers i : b.getVolumeInfo().getIndustryIdentifiers()) {
            if (i.getType().equals("ISBN_13")) {
                this.isbn = i.getIdentifier();
            }
            else {
                this.isbn = b.getVolumeInfo().getId();
            }
        }
        this.title = b.getVolumeInfo().getTitle();
        this.subtitle = b.getVolumeInfo().getSubtitle();
        this.publisher = b.getVolumeInfo().getPublisher();
        this.publishedDate = b.getVolumeInfo().getPublishedDate();
        this.description = b.getVolumeInfo().getDescription();
        this.pageCount = b.getVolumeInfo().getPageCount();
        this.thumbnailUrl = b.getVolumeInfo().getImageLinks().getThumbnail();
        this.language = b.getVolumeInfo().getLanguage();
        this.previewLink = b.getVolumeInfo().getPreviewLink();
        this.averageRating = b.getVolumeInfo().getAverageRating();
        this.authors = b.getVolumeInfo().getAuthors();
        this.categories = b.getVolumeInfo().getCategories();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPreviewLink() {
        return previewLink;
    }

    public void setPreviewLink(String previewLink) {
        this.previewLink = previewLink;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    private String isbn;
    private String title;
    private String subtitle;
    private String publisher;
    private String publishedDate;
    private String description;
    private int pageCount;
    private String thumbnailUrl;
    private String language;
    private String previewLink;
    private double averageRating;
    private ArrayList<String> authors;
    private ArrayList<String> categories;
}
