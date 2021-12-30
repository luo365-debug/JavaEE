/**
 * 描述：
 * 姚志奇 2017年4月26日 上午11:33:35
 */
package com.lol.service;

import java.util.List;

import com.lol.entity.User;

/**
 * 描述：
 * 姚志奇 2017年4月26日 上午11:33:35
 */
public interface UserService {
	User getUserById(Integer id);
	List<User> getUserList();
	void addUser(User hero);
	void deleteUser(Integer id);
	void updateUser(User hero);
}
