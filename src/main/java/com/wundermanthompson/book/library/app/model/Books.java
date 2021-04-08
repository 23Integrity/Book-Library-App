package com.wundermanthompson.book.library.app.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;

@Repository
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Books implements Serializable {
    private ArrayList<Book> items;

    public ArrayList<Book> getItems() {
        return items;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class Book implements Serializable {
        public Book.volumeInfo getVolumeInfo() {
            return volumeInfo;
        }

        private Book.volumeInfo volumeInfo;

        public static class volumeInfo {
            public String getId() {
                return id;
            }
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

            private String id;
            private String title;
            private String subtitle;
            private ArrayList<String> authors;
            private String publisher;
            private String publishedDate;
            private String description;
            private ArrayList<IndustryIdentifiers> industryIdentifiers = new ArrayList<>();
            private int pageCount;
            private ArrayList<String> categories = new ArrayList<>();
            private double averageRating;
            private String maturityRating;
            private ImageLinks imageLinks;
            private String language;
            private String previewLink;

            @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
            public static class IndustryIdentifiers {
                public String getType() {
                    return type;
                }

                public String getIdentifier() {
                    return identifier;
                }

                private String type;
                private String identifier;
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
