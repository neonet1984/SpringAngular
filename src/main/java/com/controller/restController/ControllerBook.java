package com.controller.restController;

import com.repository.entity.Book;
import com.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest")
public class ControllerBook {
    @Autowired
    BooksService booksService;

    @RequestMapping(method = RequestMethod.GET, value = "/getBooks")
    public ResponseEntity<List<Book>> getBooks() {
        ResponseEntity<List<Book>> responseEntity = new ResponseEntity<>(booksService.getListBooks(),
                HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getBookId")
    public ResponseEntity<Book> getBooks(@RequestParam Long id) {
        ResponseEntity<Book> responseEntity = new ResponseEntity<>(booksService.getBoks(id),
                HttpStatus.OK);
        return responseEntity;
    }

}
