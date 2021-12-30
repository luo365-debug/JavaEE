/**
 * 描述：
 * 姚志奇 2017年4月26日 上午11:34:10
 */
package com.lol.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lol.dao.UserDao;
import com.lol.entity.User;
import com.lol.service.UserService;

/**
 * 描述：
 * 姚志奇 2017年4月26日 上午11:34:10
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	public User getUserById(Integer id) {
		User hero = userDao.findOne(id);
		return hero;
	}
	
	public List<User> getUserList(){
		List<User> heroList = userDao.findAll();
		return heroList;
	}

	@Override
	public void addUser(User hero) {
		userDao.addOne(hero);
		return;
	}

	@Override
	public void deleteUser(Integer id) {
		userDao.deleteOne(id);
	}

	@Override
	public void updateUser(User hero) {
		userDao.updateOne(hero);
	}

}
