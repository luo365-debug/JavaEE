package com.lol.service.impl;



import com.lol.dao.ShoppingCartDao;
import com.lol.entity.ShoppingCart;
//import com.colin.mapper.ShoppingCartMapper;
import com.lol.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService
{
    @Autowired
    ShoppingCartDao shoppingCartDao;



    @Override
    public List<ShoppingCart> selectAllByUser(int uId) {
        return null;
    }

    @Override
    public void deleteCartById(Integer sId)
    {
        shoppingCartDao.deleteCartById(sId);
    }

    @Override
    public  void updateshoppingCart(Integer sId,float price)
    {
        shoppingCartDao.updateshoppingCart(sId,price);
    }

    @Override
    public List<ShoppingCart> selectById(Integer uId)
    {
        return shoppingCartDao.selectById(uId);
    }

    @Override
    public List<ShoppingCart> getShoppingCartList(){
        return shoppingCartDao.findAll();
    }
    @Override
    public List<ShoppingCart> selectSubmitCartItems(String cartItemIds)
    {
        String[] cartItemIdArray = cartItemIds.split(",");
        Integer[] sIdArray = new Integer[cartItemIdArray.length + 1];
        for (int i = 0; i < cartItemIdArray.length; i++)
        {
            sIdArray[i] = Integer.parseInt(cartItemIdArray[i]);
        }
        return shoppingCartDao.selectSubmitCartItems(sIdArray);
    }

    @Override
    public List<Integer> batchDeleteCart(Integer uId)
    {
        List<Integer> sIdList=  shoppingCartDao.batchDeleteCart(uId);
        return sIdList;
    }

    @Override
    public void insertCartItem(Integer bId, float price, int uId,int u1Id)
    {
        shoppingCartDao.insertCartItem(bId, price, uId,u1Id);
    }
}
