package com.services.servicesImpl;
import com.repository.BooksRepository;
import com.repository.entity.Book;
import com.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The service for working with books, while it can return all
 * the books metdod getListBooks(), or one book on id, getBook(Long id)
 */
@Service
public class BooksServiceImpl implements BooksService {
    @Autowired
    BooksRepository booksRepository;

    @Override
    public List<Book> getListBooks() {
        return booksRepository.findAll();
    }

    @Override
    public Book getBoks(Long id) {
        return booksRepository.findById(id).get();
    }
}
