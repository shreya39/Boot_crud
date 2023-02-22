package com.practice.Spring.boot.practice.service;

import java.util.List;

import com.practice.Spring.boot.practice.entity.Book;
import com.practice.Spring.boot.practice.error.BookNotFoundException;

public interface BookService {

	public Book saveBook(Book book);

	public List<Book> fetchBookList();

	public Book fetchBookById(Long bookId) throws BookNotFoundException;

	public void deleteBookById(Long bookId);

	public Book updateBook(Long bookId, Book book);

	public Book fetchBookByName(String bookName);

}
