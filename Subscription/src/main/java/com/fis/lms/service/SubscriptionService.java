package com.fis.lms.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.lms.entity.Subscription;
import com.fis.lms.repository.SubscriptionRepository;

@Service
public class SubscriptionService {

	@Autowired
	SubscriptionRepository subscriptionRepository;

	public List<Subscription> getAllSubscriptions() {
		return subscriptionRepository.findAll();
	}

	public Subscription addSubscription(Subscription subscription) {
		return subscriptionRepository.save(subscription);
	}

	public Subscription returnBook(Subscription subscription) {
		long miliseconds = System.currentTimeMillis();
		subscription.setDateReturned(new Date(miliseconds));
		return subscriptionRepository.save(subscription);
	}
}
