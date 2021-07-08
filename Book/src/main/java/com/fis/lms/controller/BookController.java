package com.fis.lms.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.lms.entity.Book;
import com.fis.lms.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping("/get/books")
	public ResponseEntity<Book[]> getAllBooks() {
		List<Book> bookList = bookService.getAllBooks();
		Book[] bookArray = bookList.stream().toArray(Book[]::new);
		return new ResponseEntity<Book[]>(bookArray, HttpStatus.OK);
	}

	@GetMapping("/get/books/{bookId}")
	public ResponseEntity<Book[]> getBookbyId(@PathVariable String bookId) {
		Book book = bookService.getBookbyId(bookId);
		Book[] bookArray = { book };
		return new ResponseEntity<Book[]>(bookArray, HttpStatus.OK);
	}

	@GetMapping("/get/availableCopies/{bookId}")
	public int getAvailableCopies(@PathVariable String bookId) {
		return bookService.getavailableCount(bookId);
	}

	@PostMapping("/post/books/updateAvailability/{bookId}/{incremental_count}")
	public ResponseEntity<Book[]> addBook(@PathVariable String bookId, @PathVariable int incremental_count,
			@RequestBody Book book) {
		book = bookService.getBookbyId(bookId);
		if (Objects.isNull(book) || (book.getBookId() == null && book.getBookId().isEmpty())) {
			return new ResponseEntity<Book[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			book = bookService.addBook(book, incremental_count);
			Book[] bookArray = { book };
			return new ResponseEntity<Book[]>(bookArray, HttpStatus.OK);
		}
	}

}
