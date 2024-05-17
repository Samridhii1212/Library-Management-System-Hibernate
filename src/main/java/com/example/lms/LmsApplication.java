package com.example.lms;

import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import com.example.lms.dao.BookDAO;
import com.example.lms.entity.Author;
import com.example.lms.entity.Book;
import com.example.lms.service.LibraryService;

@SpringBootApplication
public class LmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmsApplication.class, args);
		
		
		     Configuration configuration = new Configuration().configure();
	        // Build session factory
	        SessionFactory sessionFactory = configuration.buildSessionFactory();

	        // Create DAOs and services
	        BookDAO bookDAO = new BookDAO(sessionFactory);
	        LibraryService libraryService = new LibraryService(bookDAO);

	        
	        Book book = new Book();
	        book.setTitle("Sample Book");
	        Author author = new Author();
	        author.setName("John Doe");
	        book.setAuthor(author);

	        
	        libraryService.addBook(book);

	        // Find book by id
	        Book retrievedBook = libraryService.findBookById(book.getId());
	        System.out.println("Retrieved Book: " + retrievedBook.getTitle());

	       
	        sessionFactory.close();
	}

}
