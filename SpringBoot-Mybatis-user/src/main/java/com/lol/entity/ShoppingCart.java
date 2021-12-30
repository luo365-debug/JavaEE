package com.lol.entity;

import java.util.List;
import java.math.BigDecimal;

/**
 * 购物车类
 */
public class ShoppingCart
{
    private int sId; // 主键
    //private int quantity; // 数量
    private Book book; // 图书
    private float price; // 定价
    private User announcer; // 发布图书的人
    private User buyer;//买书者

    public ShoppingCart()
    {
    }

    public ShoppingCart(int sId, int quantity, Book book, User user1,User user2)
    {
        this.sId = sId;
        this.price = price;
        this.book = book;
        this.announcer = user1;
        this.buyer = user2;
    }

    @Override
    public String toString()
    {
        return "ShoppingCart{" +
                "sId=" + sId +
                ", price=" + price +
                ", book=" + book +
                ", user1=" + announcer +
                ", user2=" + buyer+
                '}';
    }

    public int getsId()
    {
        return sId;
    }

    public void setsId(int sId)
    {
        this.sId = sId;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public Book getBook()
    {
        return book;
    }

    public void setBook(Book book)
    {
        this.book = book;
    }

    public User getAnnouncer()
    {
        return announcer;
    }

    public void setAnnouncerr(User user)
    {
        this.announcer = user;
    }
    public User getBuyer()
    {
        return buyer;
    }

    public void setBuyer(User user)
    {
        this.buyer = user;
    }

//    //添加小计方法
//    //用BigDecimal计算不会有误差
//    public double getSubtotal(){
//        BigDecimal b1 = new BigDecimal(book.getPrice()+"");
//        //BigDecimal b2 = new BigDecimal(quantity+"");
//        BigDecimal b3 = b1.multiply(b2);
//        return b3.doubleValue();
//    }
}
