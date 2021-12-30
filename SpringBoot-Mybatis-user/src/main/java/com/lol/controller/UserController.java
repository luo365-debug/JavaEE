/**
 * 描述：
 * 姚志奇 2017年4月25日 下午7:47:17
 */
package com.lol.controller;
import java.util.List;

import com.lol.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lol.entity.User;
import com.lol.service.UserService;


@RestController
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private ShoppingCartService shoppingCartService;


	/**
	 * 得到所有的用户
	 * @return
	 */
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public List<User> getUserList(){
		List<User> userList = userService.getUserList();
		return userList;
	}

	/**
	 * 根据id获取用户
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	public User getHero(@PathVariable("id") Integer id){
		User hero = userService.getUserById(id);
		System.out.println("查询到 " + hero.toString());
		return hero;
	}

	/**
	 *新增用户
	 * @param hero
	 */
	@RequestMapping( value = "/user", method = RequestMethod.POST)
	public void saveUser(@RequestBody User hero) {
		System.out.println("开始新增...");
		userService.addUser(hero);
	}

	/**
	 * 根据id删除用户
	 * @param userId
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	//删除一个用户(买家)的时候，其关联的订单也要删除
	public void deleteUser(@PathVariable("id") int userId) {
		userService.deleteUser(userId);
		List<Integer> sIdList = shoppingCartService.batchDeleteCart(userId);
		for(int i = 0;i < sIdList.size();i++){
			shoppingCartService.deleteCartById(sIdList.get(i));
		}
	}

	/**
	 * 更新用户信息
	 * @param user
	 */
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public void updateUser(@RequestBody User user) {
		System.out.println("用户修改的新信息" + user.toString());
		userService.updateUser(user);
	}
	
}
