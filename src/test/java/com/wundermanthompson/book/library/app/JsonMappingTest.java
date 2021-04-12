package com.wundermanthompson.book.library.app;

import com.wundermanthompson.book.library.app.service.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class JsonMappingTest {
    @Test
    public void bookMapperShouldNotReturnNull() throws Exception{
        assertThat(BookMapper.getMappedBookList()).isNotNull();
    }

    @Test
    public void bookMapperShouldNotReturnEmptyArrayList() throws Exception {
        assertThat(BookMapper.getMappedBookList().isEmpty()).isFalse();
    }
}
