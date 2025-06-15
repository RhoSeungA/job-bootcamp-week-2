package com.example.memorydatabase.book.db.repository;

import org.springframework.stereotype.Service;

import com.example.memorydatabase.book.db.entity.BookEntity;
import com.example.memorydatabase.db.SimpleDataRepository;

@Service
public class BookRepository extends SimpleDataRepository<BookEntity, Long> {
}