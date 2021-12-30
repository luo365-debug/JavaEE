package com.lol.service.impl;

import com.lol.dao.BookDao;
import com.lol.dao.UserDao;
import com.lol.entity.Book;
import com.lol.entity.User;
import com.lol.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public Book seleteById(Integer bId) {
        Book book = bookDao.selectById(bId);
        return book;
    }
}
