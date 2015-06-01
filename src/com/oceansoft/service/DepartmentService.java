/**
* <p>
* @Title: DepartmentService.java
* <p>
* @Package com.oceansoft.service
* <p>
* @author zjw
* <p>
* @version V1.0
* <p>
* @date   2015-5-27 ����10:45:47
* <p>
*/
package com.oceansoft.service;

import java.util.List;
import java.util.Map;

import com.oceansoft.domain.Department;

/**
 * @Description: ����ҵ���ӿ�
 *
 * @author zjw
 * 
 *      @create time  2015-5-27 ����10:45:47
 */
public interface DepartmentService {

	/**
	 * Description: ���Ź����������ѯ
	 *         
	 * @create time ����12:37:56
	 *
	 * @param page
	 * @param department
	 * @return       
	 *
	 */
	public Map<String, Object> departmentList(String page, Department department);

	/**
	 * Description: ��Ӳ���
	 *         
	 * @create time ����12:57:22
	 *
	 * @param department       
	 *
	 */
	public void saveDepartment(Department department);

	/**
	 * Description: ɾ������
	 *         
	 * @create time ����1:58:15
	 *
	 * @param id
	 * @return       
	 *
	 */
	public int deleteDepartment(int id);

	/**
	 * Description: ���ݱ�ż��ز���
	 *         
	 * @create time ����2:49:35
	 *
	 * @param id
	 * @return       
	 *
	 */
	public Department findById(String id);

	/**
	 * Description: ���²���
	 *         
	 * @create time ����2:55:53
	 *
	 * @param department       
	 *
	 */
	public void updateDepartment(Department department);

	/**
	 * Description: ��ѯ���еĲ���
	 *         
	 * @create time ����9:34:51
	 *
	 * @return       
	 *
	 */
	public List<Department> findAllDepartment();

}
