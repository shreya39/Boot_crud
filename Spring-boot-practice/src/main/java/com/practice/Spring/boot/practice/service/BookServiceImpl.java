package com.practice.Spring.boot.practice.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.Spring.boot.practice.entity.Book;
import com.practice.Spring.boot.practice.error.BookNotFoundException;
import com.practice.Spring.boot.practice.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookrepository;

	@Override
	public Book saveBook(Book book) {
		return bookrepository.save(book);
	}

	@Override
	public List<Book> fetchBookList() {
	
		return bookrepository.findAll();
	}

	@Override
	public Book fetchBookById(Long bookId) throws BookNotFoundException{
		
		Optional<Book> book=bookrepository.findById(bookId);
		
		if(!book.isPresent()) {
			throw new BookNotFoundException("Book Not Available");
		}
		return book.get();
	}

	@Override
	public void deleteBookById(Long bookId) {
		
		bookrepository.deleteById(bookId);;
	}

	@Override
	public Book updateBook(Long bookId, Book book) {
		
		Book bdb=bookrepository.findById(bookId).get();
		
		if(Objects.nonNull(book.getBookName())&& !"".equalsIgnoreCase(book.getBookName())) {
			bdb.setBookName(book.getBookName());
		}
		if(Objects.nonNull(book.getBookAuthor())&& !"".equalsIgnoreCase(book.getBookAuthor())) {
			bdb.setBookAuthor(book.getBookAuthor());
		}
		if(Objects.nonNull(book.getBookCode())&& !"".equalsIgnoreCase(book.getBookCode())) {
			bdb.setBookCode(book.getBookCode());
		}
		
		return bookrepository.save(bdb);
	}

	@Override
	public Book fetchBookByName(String bookName) {
		return bookrepository.findByBookNameIgnoreCase(bookName);
	}

}
