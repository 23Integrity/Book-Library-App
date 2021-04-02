package com.wundermanthompson.book.library.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BookLibraryAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookLibraryAppApplication.class, args);
	}
}
