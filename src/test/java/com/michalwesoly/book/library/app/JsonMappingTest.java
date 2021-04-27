package com.michalwesoly.book.library.app;

import com.michalwesoly.book.library.app.service.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class JsonMappingTest {
    @Test
    public void bookMapperShouldNotReturnNull() {
        assertThat(BookMapper.getMappedBookList()).isNotNull();
    }

    @Test
    public void bookMapperShouldNotReturnEmptyArrayList() {
        assertThat(BookMapper.getMappedBookList().isEmpty()).isFalse();
    }
}
