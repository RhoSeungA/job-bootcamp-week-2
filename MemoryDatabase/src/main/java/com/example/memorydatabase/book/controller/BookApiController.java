package com.example.memorydatabase.book.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.memorydatabase.book.db.entity.BookEntity;
import com.example.memorydatabase.book.service.BookService;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookApiController {

	private final BookService bookService;


	@PostMapping("")
	public BookEntity create(
		@RequestBody BookEntity bookEntity
	){
		return bookService.create(bookEntity);
	}

	@GetMapping("/all")
	public List<BookEntity> findAll(

	){
		return bookService.findAll();
	}

}
