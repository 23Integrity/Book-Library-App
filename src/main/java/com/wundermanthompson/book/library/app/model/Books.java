package com.wundermanthompson.book.library.app.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Books implements Serializable {
    private ArrayList<Book> items;
    public ArrayList<Book> getItems() {
        return items;
    }

    @Component
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class Book implements Serializable {
        private String id;
        private Book.volumeInfo volumeInfo;

        public String getId() { return id; }
        public Book.volumeInfo getVolumeInfo() {
            return volumeInfo;
        }

        public static class volumeInfo {
            private String title;
            private String subtitle;
            private ArrayList<String> authors;
            private String publisher;
            private String publishedDate;
            private String description;
            private ArrayList<Book.volumeInfo.IndustryIdentifiers> industryIdentifiers = new ArrayList<>();
            private int pageCount;
            private ArrayList<String> categories = new ArrayList<>();
            private double averageRating;
            private String maturityRating;
            private Book.volumeInfo.ImageLinks imageLinks;
            private String language;
            private String previewLink;

            public String getTitle() {
                return title;
            }

            public String getSubtitle() {
                return subtitle;
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

            public ArrayList<IndustryIdentifiers> getIndustryIdentifiers() {
                return industryIdentifiers;
            }

            public int getPageCount() {
                return pageCount;
            }

            public ArrayList<String> getCategories() {
                return categories;
            }

            public double getAverageRating() {
                return averageRating;
            }

            public String getMaturityRating() {
                return maturityRating;
            }

            public ImageLinks getImageLinks() {
                return imageLinks;
            }

            public String getLanguage() {
                return language;
            }

            public String getPreviewLink() {
                return previewLink;
            }

            @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
            public static class IndustryIdentifiers {
                private String type = "";
                private String identifier = "";

                public String getType() {
                    return type;
                }

                public String getIdentifier() {
                    return identifier;
                }
            }
            @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
            public static class ImageLinks {
                public String getSmallThumbnail() {
                    return smallThumbnail;
                }
                public String getThumbnail() {
                    return thumbnail;
                }

                private String smallThumbnail;
                private String thumbnail;
            }
        }
    }
}
