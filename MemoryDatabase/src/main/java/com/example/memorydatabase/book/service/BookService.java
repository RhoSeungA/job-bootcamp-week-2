package com.example.memorydatabase.book.service;


import org.springframework.stereotype.Service;

import java.util.List;

import com.example.memorydatabase.book.db.entity.BookEntity;
import com.example.memorydatabase.book.db.repository.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository){
		this.bookRepository = bookRepository;
	}


	// create , update
	public BookEntity create(BookEntity book){
		return bookRepository.save(book);
	}

	// all
	public List<BookEntity> findAll(){
		return bookRepository.findAll();
	}

	// delete

	// find one
}