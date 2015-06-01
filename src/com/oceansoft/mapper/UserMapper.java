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
* @date   2015-5-27 ����4:03:47
* <p>
*/
package com.oceansoft.mapper;

import java.util.List;
import java.util.Map;

import com.oceansoft.domain.User;

/**
 * @Description: �û���¼���ݲ�ӿ�
 *
 * @author zjw
 * 
 *      @create time  2015-5-27 ����4:03:47
 */
public interface UserMapper {
	
	/***
	 * 
	 * Description: �û���¼
	 *         
	 * @create time ����4:07:16
	 *
	 * @param user
	 * @return       
	 *
	 */
	public User login(User user);

	/**
	 * Description: �û������������ѯ
	 *         
	 * @create time ����5:06:55
	 *
	 * @param params
	 * @return       
	 *
	 */
	public List<User> getUserList(Map<String, Object> params);

	/**
	 * Description: ��ѯ���������ļ�¼����
	 *         
	 * @create time ����5:07:06
	 *
	 * @param user
	 * @return       
	 *
	 */
	public int getUserListTotal(User user);

	/**
	 * Description: ɾ��ָ���û�
	 *         
	 * @create time ����8:31:49
	 *
	 * @param id
	 * @return       
	 *
	 */
	public int deleteUser(int id);

	/**
	 * Description: ���ݱ�Ų����û�
	 *         
	 * @create time ����8:39:07
	 *
	 * @param id
	 * @return       
	 *
	 */
	public User findById(int id);

	/**
	 * Description: ����û�
	 *         
	 * @create time ����9:53:18
	 *
	 * @param user       
	 *
	 */
	public void saveUser(User user);

	/**
	 * Description: �޸��û�
	 *         
	 * @create time ����9:53:22
	 *
	 * @param user       
	 *
	 */
	public void updateUser(User user);

	/**
	 * Description: ������Ӧ���ŵ�����
	 *         
	 * @create time ����10:10:36
	 *
	 * @param id
	 * @return       
	 *
	 */
	public int getTotalByDept(int id);

}
