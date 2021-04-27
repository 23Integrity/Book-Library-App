package com.michalwesoly.book.library.app.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;


/*
 * Books class is a collection of Books.Book - so of objects from JSON, which are books.
 * Used for mapping.
 */
@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Books implements Serializable {
    private ArrayList<BookTemplate> items;
    public ArrayList<BookTemplate> getItems() {
        return items;
    }

    // Singular book from JSON; ignoring useless fields
    @Component
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class BookTemplate implements Serializable {
        private String id;
        private BookTemplate.volumeInfo volumeInfo;

        public String getId() { return id; }
        public BookTemplate.volumeInfo getVolumeInfo() {
            return volumeInfo;
        }

        public static class volumeInfo {
            private String title;
            private String subtitle;
            private ArrayList<String> authors;
            private String publisher;
            private String publishedDate;
            private String description;
            private ArrayList<BookTemplate.volumeInfo.IndustryIdentifiers> industryIdentifiers = new ArrayList<>();
            private int pageCount;
            private ArrayList<String> categories = new ArrayList<>();
            private double averageRating;
            private String maturityRating;
            private BookTemplate.volumeInfo.ImageLinks imageLinks;
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
