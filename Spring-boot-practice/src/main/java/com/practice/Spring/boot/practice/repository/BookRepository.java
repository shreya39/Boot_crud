package com.practice.Spring.boot.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.Spring.boot.practice.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
	
	public Book findByBookName(String bookName);
	
	public Book findByBookNameIgnoreCase(String bookName);

}
