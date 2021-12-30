package com.lol.entity;

import java.util.List;

public class Shoppinglist {
    public Integer id;
    public Integer booknumber;
    public List<Book> books;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookNumber() {
        return booknumber;
    }

    public void setBookNumber(Integer bookNumber) {
        this.booknumber = bookNumber;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
