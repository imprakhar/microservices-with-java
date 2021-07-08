package com.fis.lms.helper;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "Book")
public interface BookProxy {

	@GetMapping("/api/get/availableCopies/{bookId}")
	public int getAvailableCopies(@PathVariable String bookId);

	@PostMapping("/api/post/books/updateAvailability/{bookId}/{incremental_count}")
	public ResponseEntity<Book[]> addBook(@PathVariable String bookId, @PathVariable int incremental_count,
			@RequestBody Book book);

	@GetMapping("/api/get/books/{bookId}")
	public ResponseEntity<Book[]> getBookbyId(@PathVariable String bookId);

}
