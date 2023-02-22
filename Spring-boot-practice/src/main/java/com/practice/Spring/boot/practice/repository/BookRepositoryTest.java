package com.practice.Spring.boot.practice.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.practice.Spring.boot.practice.entity.Book;

@DataJpaTest
class BookRepositoryTest {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private TestEntityManager entityManager;

	@BeforeEach
	void setUp() {
		Book book = new Book();
		book.setBookName("humm");
		book.setBookAuthor("Jaye");
		book.setBookCode("R-04");

		entityManager.persist(book);
	}

	@Test
	public void whenFindById_thenReturnBook() {
		Book book = bookRepository.findById(1L).get();

		assertEquals(book.getBookName(), "humm");
	}

}
