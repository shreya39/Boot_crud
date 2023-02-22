package com.practice.Spring.boot.practice.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.Spring.boot.practice.entity.Book;
import com.practice.Spring.boot.practice.error.BookNotFoundException;
import com.practice.Spring.boot.practice.service.BookService;

@RestController
//@CrossOrigin(origins="http://localhost:3000")
public class BookController {
	
	@Autowired
	private BookService bookservice;
	
	private final Logger log= LoggerFactory.getLogger(BookController.class);
	
	@PostMapping(value="/books")
	public Book saveBook(@Valid @RequestBody Book book) {
		
		log.info("EXECUTION SUCCESSFUL !!!");
		return bookservice.saveBook(book);
		
	}
	
	@GetMapping(value="/books")
	public List<Book> fetchBookList(){
		return bookservice.fetchBookList();
	}
	
	@GetMapping(value="/books/{id}")
	public Book fetchBookById(@PathVariable("id") Long bookId) throws BookNotFoundException {
		return bookservice.fetchBookById(bookId);
	}
	
	@DeleteMapping(value="/books/{id}")
	public String deleteBookById(@PathVariable("id") Long bookId) {
		
		bookservice.deleteBookById(bookId);
		return "Book deletion successful" ;
	}
	
	@PutMapping("/books/{id}")
	public Book updateBook(@PathVariable("id") Long bookId,
			               @RequestBody Book book) {
		return bookservice.updateBook(bookId, book);
		
	}
	
	@GetMapping("/books/name/{name}")
	public Book fetchBookByName(@PathVariable("name") String bookName) {
		return bookservice.fetchBookByName(bookName);
	}

}
