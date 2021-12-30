package com.lol.controller;

import com.lol.entity.ShoppingCart;
import com.lol.entity.User;

import com.lol.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.ws.rs.PathParam;
import java.math.BigDecimal;
import java.util.*;

@RestController
//@RequestMapping("/shoppingCart")
public class ShoppingCartController
{
    @Autowired
    ShoppingCartService shoppingCartService;


    //查看所有的订单
    @RequestMapping(value="/shoppingcart",method=RequestMethod.GET)
    public List<ShoppingCart> getShoppingCartList(){
        List<ShoppingCart> ShoppingCart = shoppingCartService.getShoppingCartList();
        return ShoppingCart;
    }
    //根据id查看订单 这里为了网站，改成根据发布图书人的id查看发布的图书
    @RequestMapping(value = "/shoppingcart/{uId}",method=RequestMethod.GET)
    public List<ShoppingCart> getCart(@PathVariable("uId")Integer uId){
        System.out.println("发布图书者为 " + uId);
        List<ShoppingCart> shoppingCart =  shoppingCartService.selectById(uId);
        return shoppingCart;

    }
    //根据卖家查看其有的订单

    //删除
    @RequestMapping(value ="/shoppingcart/{sId}",method = RequestMethod.DELETE)
    public boolean deleteCart(@PathVariable("sId")Integer sId)
    {
        try{
            shoppingCartService.deleteCartById(sId);
            System.out.println("删除订单" + sId);
            return true;
        }catch(Exception e) {
            return false;
        }
    }
//    //根据用户id删除订单
//    @RequestMapping(value ="/shoppingcart", method = RequestMethod.DELETE)
//    public boolean deleteBatchCart()

    //增加订单
    @RequestMapping(value ="/shoppingcart", method = RequestMethod.POST)
    //不知道为什么用PathParam出现null 还有required = false属性设置前端可以不传数据
    public boolean addBookToCart(@RequestBody Map<String,Object> cartMap)
    {
        try {
            float price = Float.valueOf(cartMap.get("price").toString());
            shoppingCartService.insertCartItem((Integer)cartMap.get("b_id"),price,(Integer) cartMap.get("u_id"),(Integer) cartMap.get("u1_id"));
            System.out.println("新增订单");
            return true;
        }catch (Exception e){
            System.out.println("新增订单失败");
            return  false;
        }

    }

    //修改订单，但是只能修改书的价格与买书者,书的发布者与图书是主键值,此处是修改书的价格
    @RequestMapping(value = "/shoppingcart", method = RequestMethod.PUT)
    public boolean updateUser(@RequestBody Map<String,Object> priceMap) {
        try {
            float price = Float.valueOf(priceMap.get("price").toString());
            System.out.println("开始更新...");
            shoppingCartService.updateshoppingCart((Integer)priceMap.get("sId"),price);
            return true;
        }catch (Exception e){
            return false;
        }

    }

}
