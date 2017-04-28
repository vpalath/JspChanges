package com.library.controller;

import com.library.book.domain.Book;

public interface BookService {
	
	public String saveBook(Book book);
	
	
	public Book findByAcademicClass(String academicClass);
	public Book findByAuthor(String authorName);
	public Book findByTitle(String title);
	public Book findByGenre(String genre);
	public Book findByAvailability(boolean status);

}
