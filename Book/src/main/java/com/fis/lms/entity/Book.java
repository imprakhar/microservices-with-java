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
@Table(name = "BOOK")
public class Book {

	@Id
	@Column(name = "BOOK_ID")
	private String bookId;

	@Column(name = "BOOK_NAME")
	private String bookName;

	@Column(name = "AUTHOR")
	private String author;

	@Column(name = "AVAILABLE_COPIES")
	private int availableCopies;

	@Column(name = "TOTAL_COPIES")
	private int totalCopies;
}
