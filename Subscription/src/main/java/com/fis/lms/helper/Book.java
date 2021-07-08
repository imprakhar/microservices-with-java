package com.fis.lms.helper;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Book {

	private String bookId;

	private String bookName;

	private String author;

	private int availableCopies;

	private int totalCopies;
}
