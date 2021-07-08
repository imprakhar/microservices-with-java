package com.fis.lms.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "subscription")
public class Subscription {

	@Id
	@Column(name = "SUBSCRIBER_NAME")
	private String subscriberName;

	@Column(name = "DATE_SUBSCRIBED")
	private Date dateSubscribed;

	@Column(name = "DATE_RETURNED")
	private Date dateReturned;

	@Column(name = "BOOK_ID")
	private String bookId;

}
