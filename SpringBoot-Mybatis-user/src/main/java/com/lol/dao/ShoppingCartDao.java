package com.lol.dao;

import com.lol.entity.ShoppingCart;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import java.util.List;

public interface ShoppingCartDao
{
    //
    List<ShoppingCart> selectById(Integer uId);
    List<ShoppingCart> findAll();
    //批量删除订单
   List<Integer> batchDeleteCart(Integer uId);
    @Delete("delete from shopping_cart where s_id = #{sId}")
    void deleteCartById(Integer sId);

    //修改书的价格
    @Update("update shopping_cart set price = #{param2} where s_id = #{param1}")
    void updateshoppingCart(Integer sId,float price);
    List<ShoppingCart> selectSubmitCartItems(Integer[] sIdArray);
    @Insert("insert into shopping_cart values(#{param2}, #{param1}, #{param3},#{param4})")
    void insertCartItem(Integer bId, float price, int uId,int u1Id);
}
