package com.michalwesoly.book.library.app.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * Exception for throwing 404 HTTP Error in case if there's no such book
 * with specified amount of pages in BookVolumeController
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No such book")
public class BookNotFoundException extends RuntimeException{ }
