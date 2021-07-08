package com.fis.lms.controller;

import java.lang.reflect.Array;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.lms.entity.Subscription;
import com.fis.lms.helper.Book;
import com.fis.lms.helper.BookProxy;
import com.fis.lms.service.SubscriptionService;

@RestController
@RequestMapping("/api")
public class SubscriptionController {
	
	Logger logger = LoggerFactory.getLogger(SubscriptionController.class);

	@Autowired
	SubscriptionService subscriptionService;

	@Autowired
	BookProxy bookProxy;

	@GetMapping("/get/subscriptions")
	public ResponseEntity<Subscription[]> getAllSubscriptions() {
		List<Subscription> subscriptionList = subscriptionService.getAllSubscriptions();
		Subscription[] subscriptionArray = subscriptionList.stream().toArray(Subscription[]::new);
		logger.info("User Retrieved");
		return new ResponseEntity<Subscription[]>(subscriptionArray, HttpStatus.OK);
	}

	@PostMapping("/post/subscription")
	public ResponseEntity<Subscription[]> addSubscription(@RequestBody Subscription subscription) {
		String bookId = subscription.getBookId();
		if (bookProxy.getAvailableCopies(bookId) > 0) {
			subscription = subscriptionService.addSubscription(subscription);
			bookProxy.addBook(bookId, -1, (Book) Array.get(bookProxy.getBookbyId(bookId).getBody(), 0));
			Subscription[] subscriptionArray = { subscription };
			return new ResponseEntity<Subscription[]>(subscriptionArray, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Subscription[]>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@PostMapping("/post/returns")
	public ResponseEntity<Subscription[]> returns(@RequestBody Subscription subscription) {
		String bookId = subscription.getBookId();
		bookProxy.addBook(bookId, +1, (Book) Array.get(bookProxy.getBookbyId(bookId).getBody(), 0));
		subscription = subscriptionService.returnBook(subscription);
		Subscription[] subscriptionArray = { subscription };
		return new ResponseEntity<Subscription[]>(subscriptionArray, HttpStatus.CREATED);
	}

}
