package com.fis.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.lms.entity.Book;
import com.fis.lms.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public Book getBookbyId(String id) {
		Book book = bookRepository.findById(id).get();
		return book;
	}

	public Book addBook(Book book, int availableCopies) {
		book.setAvailableCopies(book.getAvailableCopies() + availableCopies);
		if (book.getAvailableCopies() > book.getTotalCopies()) {
			book.setAvailableCopies(availableCopies + book.getTotalCopies());
		}
		book = bookRepository.save(book);
		return book;
	}
	
	public int getavailableCount(String id) {
		Book book = bookRepository.findById(id).get();
		return book.getAvailableCopies();
	}
}
