package com.services;

import com.repository.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BooksService {
     List<Book> getListBooks();
     Book getBoks(Long id);
}
