package com.wundermanthompson.book.library.app.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class BookExceptions {

    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Category not found")
    static class CategoryNotFound extends RuntimeException {
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Wrong data entered")
    static class WrongID extends RuntimeException {
    }
}
