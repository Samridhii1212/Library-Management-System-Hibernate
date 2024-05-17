package com.example.lms.service;

import com.example.lms.dao.BookDAO;
import com.example.lms.entity.Book;

public class LibraryService {
	 private BookDAO bookDAO;

	    public LibraryService(BookDAO bookDAO) {
	        this.bookDAO = bookDAO;
	    }

	    public void addBook(Book book) {
	        bookDAO.saveOrUpdate(book);
	    }

	    public Book findBookById(Long id) {
	        return bookDAO.findById(id);
	    }

}
