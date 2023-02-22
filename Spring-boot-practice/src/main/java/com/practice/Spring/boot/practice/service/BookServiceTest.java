package com.practice.Spring.boot.practice.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.practice.Spring.boot.practice.entity.Book;
import com.practice.Spring.boot.practice.repository.BookRepository;

@SpringBootTest
class BookServiceTest {
	
	@Autowired
	private BookService bookService;
	
	@MockBean
	private BookRepository bookRepository;

	@BeforeEach
	void setUp(){
		Book book= new Book();
		book.setBookName("Pride");
		book.setBookAuthor("Jane");
		book.setBookCode("ROM-04");
		
		Mockito.when(bookRepository.findByBookNameIgnoreCase("Pride")).thenReturn(book);
		
	}

	@Test
	@DisplayName("Validating bookName")
	public void whenValidBookName_thenBookShouldFound() {
	    String bookName="Pride";
	    Book found=bookService.fetchBookByName(bookName);
	    
	    assertEquals(bookName,found.getBookName());
	}

}
