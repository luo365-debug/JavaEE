package com.lol.service;


import com.lol.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartService
{
    List<ShoppingCart> selectAllByUser(int uId);
    //删除
    void deleteCartById(Integer sId);
    //改
    void updateshoppingCart(Integer sId,float price);
    //查
    List<ShoppingCart> selectById(Integer uId);
    List<ShoppingCart> getShoppingCartList();

    List<ShoppingCart> selectSubmitCartItems(String cartItemIds);

    List<Integer> batchDeleteCart(Integer uId);
    //增
    void insertCartItem(Integer bId, float price, int uId,int u1Id);
}

