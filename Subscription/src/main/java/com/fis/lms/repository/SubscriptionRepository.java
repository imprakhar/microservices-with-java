package com.fis.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fis.lms.entity.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, String>{

}
