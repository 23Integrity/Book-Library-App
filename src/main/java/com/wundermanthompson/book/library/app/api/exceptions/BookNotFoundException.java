package com.wundermanthompson.book.library.app.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No such book")
public class BookNotFoundException extends RuntimeException{ }
