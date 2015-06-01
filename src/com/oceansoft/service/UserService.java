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
* @date   2015-5-27 ����4:05:32
* <p>
*/
package com.oceansoft.service;

import java.util.Map;

import com.oceansoft.domain.User;

/**
 * @Description: �û���¼ҵ���ӿ�
 *
 * @author zjw
 * 
 *      @create time  2015-5-27 ����4:05:32
 */
public interface UserService {
	
	/***
	 * 
	 * Description: �û���¼
	 *         
	 * @create time ����4:07:46
	 *
	 * @param user
	 * @return       
	 *
	 */
	public User login(User user);

	/**
	 * Description: �û��������ѯ
	 *         
	 * @create time ����5:01:28
	 *
	 * @param page
	 * @param user
	 * @return       
	 *
	 */
	public Map<String, Object> userList(String page, User user);

	/**
	 * Description: ɾ��ָ���û�
	 *         
	 * @create time ����8:31:25
	 *
	 * @param id
	 * @return       
	 *
	 */
	public int deleteUser(int id);

	/**
	 * Description: ���ݱ�Ų����û�
	 *         
	 * @create time ����8:38:35
	 *
	 * @param id
	 * @return       
	 *
	 */
	public User findById(int id);

	/**
	 * Description: ����û�
	 *         
	 * @create time ����9:52:19
	 *
	 * @param user       
	 *
	 */
	public void saveUser(User user);

	/**
	 * Description: �����û�
	 *         
	 * @create time ����9:52:29
	 *
	 * @param user       
	 *
	 */
	public void updateUser(User user);

	/**
	 * Description: ������Ӧ��������
	 *         
	 * @create time ����10:05:32
	 *
	 * @param id
	 * @return       
	 *
	 */
	
	public int getTotalByDept(int id);
	
}
