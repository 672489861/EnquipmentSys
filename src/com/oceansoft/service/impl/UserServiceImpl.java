/**
* <p>
* @Title: UserServiceImpl.java
* <p>
* @Package com.oceansoft.service.impl
* <p>
* @author zjw
* <p>
* @version V1.0
* <p>
* @date   2015-5-27 下午4:06:02
* <p>
*/
package com.oceansoft.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oceansoft.annotation.ReadOnlyTransaction;
import com.oceansoft.annotation.ReadWriteTransaction;
import com.oceansoft.common.Constants;
import com.oceansoft.domain.User;
import com.oceansoft.mapper.UserMapper;
import com.oceansoft.service.UserService;
import com.oceansoft.util.PageBean;

/**
 * @Description: 用户业务层实现类
 *
 * @author zjw
 * 
 *      @create time  2015-5-27 下午4:06:02
 */
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	@Override
	@ReadOnlyTransaction
	public User login(User user) {
		return userMapper.login(user);
	}

	@Override
	@ReadOnlyTransaction
	public Map<String, Object> userList(String page, User user) {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Constants.pageSize);
		Map<String, Object> params = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		params.put("start", pageBean.getStart());
		params.put("size", Constants.pageSize);
		params.put("user", user);
		List<User> users = userMapper.getUserList(params);
		int total = userMapper.getUserListTotal(user);
		resultMap.put("userList", users);
		resultMap.put("total", total);
		return resultMap;
	}

	@Override
	@ReadWriteTransaction
	public int deleteUser(int id) {
		return userMapper.deleteUser(id);
	}

	@Override
	@ReadOnlyTransaction
	public User findById(int id) {
		return userMapper.findById(id);
	}

	@Override
	@ReadWriteTransaction
	public void saveUser(User user) {
		userMapper.saveUser(user);
	}

	@Override
	@ReadWriteTransaction
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	@Override
	@ReadOnlyTransaction
	public int getTotalByDept(int id) {
		return userMapper.getTotalByDept(id);
	}

}
