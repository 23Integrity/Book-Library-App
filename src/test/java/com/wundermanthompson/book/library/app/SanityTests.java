package com.wundermanthompson.book.library.app;

import com.wundermanthompson.book.library.app.api.*;
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
    public void allBooksControllerShouldNotBeNull() throws Exception {
        assertThat(allBooksController).isNotNull();
    }

    @Test
    public void bookDetailsControllerShouldNotBeNull() throws Exception {
        assertThat(bookDetailsController).isNotNull();
    }

    @Test
    public void bookVolumeControllerShouldNotBeNull() throws Exception {
        assertThat(bookVolumeController).isNotNull();
    }

    @Test
    public void categoriesControllerShouldNotBeNull() throws Exception {
        assertThat(categoriesController).isNotNull();
    }

    @Test
    public void ratingControllerShouldNotBeNull() throws Exception {
        assertThat(ratingController).isNotNull();
    }
}
