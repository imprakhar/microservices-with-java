package com.fis.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fis.lms.entity.Book;

public interface BookRepository extends JpaRepository<Book, String> {

}
