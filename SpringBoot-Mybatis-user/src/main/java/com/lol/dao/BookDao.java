package com.lol.dao;

import com.lol.entity.Book;
import com.lol.entity.ShoppingCart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;


public interface BookDao {
    //@Select("select b_id,b_name from book where b_id = #{bId}")
    Book selectById(Integer bId);
}
