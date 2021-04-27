package com.michalwesoly.book.library.app;

import com.michalwesoly.book.library.app.api.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

// Sanity check
@SpringBootTest
public class SanityTests {
    @Autowired
    AllBooksController allBooksController = new AllBooksController();

    @Autowired
    BookDetailsController bookDetailsController = new BookDetailsController();

    @Autowired
    BookVolumeController bookVolumeController = new BookVolumeController();

    @Autowired
    CategoriesController categoriesController = new CategoriesController();

    @Autowired
    RatingController ratingController = new RatingController();

    @Test
    public void allBooksControllerShouldNotBeNull() {
        assertThat(allBooksController).isNotNull();
    }

    @Test
    public void bookDetailsControllerShouldNotBeNull() {
        assertThat(bookDetailsController).isNotNull();
    }

    @Test
    public void bookVolumeControllerShouldNotBeNull()  {
        assertThat(bookVolumeController).isNotNull();
    }

    @Test
    public void categoriesControllerShouldNotBeNull() {
        assertThat(categoriesController).isNotNull();
    }

    @Test
    public void ratingControllerShouldNotBeNull() {
        assertThat(ratingController).isNotNull();
    }
}
