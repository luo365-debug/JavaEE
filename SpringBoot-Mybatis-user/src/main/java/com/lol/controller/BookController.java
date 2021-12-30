package com.lol.controller;

import com.lol.entity.User;
import com.lol.service.BookService;
import com.lol.entity.Book;
import com.lol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value="/book/{id}",method= RequestMethod.GET)
    public Book getBook(@PathVariable("id") Integer id){
        Book book = bookService.seleteById(id);
        return book;
    }

}
