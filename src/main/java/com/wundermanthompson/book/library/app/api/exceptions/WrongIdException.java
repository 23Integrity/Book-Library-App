package com.wundermanthompson.book.library.app.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Wrong data entered")
public class WrongIdException extends RuntimeException { }
