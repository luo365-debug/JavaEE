package com.lol.entity;



import java.io.Serializable;

/**
 * 图书类
 */
public class Book implements Serializable
{
    private int bId; // 主键
    private String bName; // 书名
    private String author; // 作者
    public Book()
    {
    }

    public Book(int bId, String bName, String author, double price )
    {
        this.bId = bId;
        this.bName = bName;
        this.author = author;
       // this.price = price;

    }

    @Override
    public String toString()
    {
        return "Book{" +
                "bId=" + bId +
                ", bName='" + bName + '\'' +
                ", author='" + author + '\'' +
                //", price=" + price +

                '}';
    }

    public int getbId()
    {
        return bId;
    }

    public void setbId(int bId)
    {
        this.bId = bId;
    }

    public String getbName()
    {
        return bName;
    }

    public void setbName(String bName)
    {
        this.bName = bName;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

//    public double getPrice()
//    {
//        return price;
//    }

//    public void setPrice(double price)
//    {
//        this.price = price;
//    }

}
