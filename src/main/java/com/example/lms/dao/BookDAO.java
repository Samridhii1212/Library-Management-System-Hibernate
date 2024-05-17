package com.example.lms.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.lms.entity.Book;

public class BookDAO {
	
	 private SessionFactory sessionFactory;

	    public BookDAO(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }

	    public void saveOrUpdate(Book book) {
	        Session session = sessionFactory.getCurrentSession();
	        session.persist(book);
	    }

	    public Book findById(Long id) {
	        Session session = sessionFactory.getCurrentSession();
	        return session.get(Book.class, id);
	    }

}
