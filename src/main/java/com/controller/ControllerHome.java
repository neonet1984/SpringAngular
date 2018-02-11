package com.controller;

import com.repository.entity.Book;
import com.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/mainPage")
public class ControllerHome {
    private static final Logger LOG = LoggerFactory.getLogger(ControllerHome.class);

    @Autowired
    BooksService booksServices;

    @Autowired
    UserDetailsService userDetails;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model) {

        LOG.info("got into the controller");

        List<Book> bookList = booksServices.getListBooks();
        model.addAttribute("booksList", bookList);
        model.addAttribute("cod", "menu");
        return "index";
    }
}
