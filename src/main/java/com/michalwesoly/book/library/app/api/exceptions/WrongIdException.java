package com.michalwesoly.book.library.app.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * Exception for throwing 500 Bad Request upon searching for a book by ID / ISBN
 * and not finding one.
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Wrong data entered")
public class WrongIdException extends RuntimeException { }
