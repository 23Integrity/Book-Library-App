package com.michalwesoly.book.library.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.michalwesoly.book.library.app.service.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

// General HTTP test
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestsTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void allBooksShouldReturnMappedBooksList() throws Exception {
        assumeTrue(this.restTemplate.getForObject("http://localhost:"
        + port + "/all-books", String.class).contains(new ObjectMapper().writeValueAsString(BookMapper.getMappedBookList())));
    }


}
