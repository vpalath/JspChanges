package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.book.domain.Book;
import com.library.book.domain.BookAuthor;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	BookAuthorRepository bookAuthorRepository;

	@Override
	public String saveBook(Book book) {
		bookRepository.save(book);
		return "SUCCESS";
	}

	@Override
	public Book findByAcademicClass(String academicClass) {
		return bookRepository.findByAcademicclass(academicClass);
		 
	}

	@Override
	public Book findByAuthor(String authorName) {

		BookAuthor bookAuthor = bookAuthorRepository.findByAuthorname(authorName);
		return bookRepository.findByBookisbnno(bookAuthor.getIsbnno());
	}

	@Override
	public Book findByTitle(String title) {

		return bookRepository.findByTitle(title);
	}

	@Override
	public Book findByGenre(String genre) {

		return bookRepository.findByGenre(genre);
	}

	@Override
	public Book findByAvailability(boolean status) {

		return bookRepository.findByStatus(status);
	}

}
