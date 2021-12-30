/**
 * 描述：
 * 姚志奇 2017年4月26日 上午11:31:15
 */
package com.lol.dao;
import java.util.List;

import com.lol.entity.User;

public interface UserDao {
	/**
	 * 描述：按照id查找hero
	 * @param id
	 * @return
	 */
	User findOne(Integer id);
	/**
	 * 描述：查找所有的hero
	 * @return
	 */
	List<User> findAll();

	/**
	 * 增加一个用户
	 * @param hero
	 * @return
	 */
	void addOne(User hero);

	/**
	 * 删除一个用户
	 * @param id
	 */
	void deleteOne(Integer id);

	/**
	 * 更新用户信息
	 * @param hero
	 */
	void updateOne(User hero);
}
