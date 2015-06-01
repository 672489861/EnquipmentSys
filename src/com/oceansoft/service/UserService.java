/**
* <p>
* @Title: UserService.java
* <p>
* @Package com.oceansoft.service
* <p>
* @author zjw
* <p>
* @version V1.0
* <p>
* @date   2015-5-27 下午4:05:32
* <p>
*/
package com.oceansoft.service;

import java.util.Map;

import com.oceansoft.domain.User;

/**
 * @Description: 用户登录业务层接口
 *
 * @author zjw
 * 
 *      @create time  2015-5-27 下午4:05:32
 */
public interface UserService {
	
	/***
	 * 
	 * Description: 用户登录
	 *         
	 * @create time 下午4:07:46
	 *
	 * @param user
	 * @return       
	 *
	 */
	public User login(User user);

	/**
	 * Description: 用户主界面查询
	 *         
	 * @create time 下午5:01:28
	 *
	 * @param page
	 * @param user
	 * @return       
	 *
	 */
	public Map<String, Object> userList(String page, User user);

	/**
	 * Description: 删除指定用户
	 *         
	 * @create time 下午8:31:25
	 *
	 * @param id
	 * @return       
	 *
	 */
	public int deleteUser(int id);

	/**
	 * Description: 根据编号查找用户
	 *         
	 * @create time 下午8:38:35
	 *
	 * @param id
	 * @return       
	 *
	 */
	public User findById(int id);

	/**
	 * Description: 添加用户
	 *         
	 * @create time 下午9:52:19
	 *
	 * @param user       
	 *
	 */
	public void saveUser(User user);

	/**
	 * Description: 更新用户
	 *         
	 * @create time 下午9:52:29
	 *
	 * @param user       
	 *
	 */
	public void updateUser(User user);

	/**
	 * Description: 加载相应部门人数
	 *         
	 * @create time 下午10:05:32
	 *
	 * @param id
	 * @return       
	 *
	 */
	
	public int getTotalByDept(int id);
	
}
