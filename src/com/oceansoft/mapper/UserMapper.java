/**
* <p>
* @Title: UserMapper.java
* <p>
* @Package com.oceansoft.mapper.impl
* <p>
* @author zjw
* <p>
* @version V1.0
* <p>
* @date   2015-5-27 下午4:03:47
* <p>
*/
package com.oceansoft.mapper;

import java.util.List;
import java.util.Map;

import com.oceansoft.domain.User;

/**
 * @Description: 用户登录数据层接口
 *
 * @author zjw
 * 
 *      @create time  2015-5-27 下午4:03:47
 */
public interface UserMapper {
	
	/***
	 * 
	 * Description: 用户登录
	 *         
	 * @create time 下午4:07:16
	 *
	 * @param user
	 * @return       
	 *
	 */
	public User login(User user);

	/**
	 * Description: 用户管理主界面查询
	 *         
	 * @create time 下午5:06:55
	 *
	 * @param params
	 * @return       
	 *
	 */
	public List<User> getUserList(Map<String, Object> params);

	/**
	 * Description: 查询满足条件的记录条数
	 *         
	 * @create time 下午5:07:06
	 *
	 * @param user
	 * @return       
	 *
	 */
	public int getUserListTotal(User user);

	/**
	 * Description: 删除指定用户
	 *         
	 * @create time 下午8:31:49
	 *
	 * @param id
	 * @return       
	 *
	 */
	public int deleteUser(int id);

	/**
	 * Description: 根据编号查找用户
	 *         
	 * @create time 下午8:39:07
	 *
	 * @param id
	 * @return       
	 *
	 */
	public User findById(int id);

	/**
	 * Description: 添加用户
	 *         
	 * @create time 下午9:53:18
	 *
	 * @param user       
	 *
	 */
	public void saveUser(User user);

	/**
	 * Description: 修改用户
	 *         
	 * @create time 下午9:53:22
	 *
	 * @param user       
	 *
	 */
	public void updateUser(User user);

	/**
	 * Description: 加载相应部门的人数
	 *         
	 * @create time 下午10:10:36
	 *
	 * @param id
	 * @return       
	 *
	 */
	public int getTotalByDept(int id);

}
