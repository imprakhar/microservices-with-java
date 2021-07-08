package com.fis.lms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class User {
	
	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "SUBSCRIBER_NAME")
	private String subscriberName;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PASSWORD")
	private String password;

}
