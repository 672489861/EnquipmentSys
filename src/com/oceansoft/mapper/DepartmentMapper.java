/**
* <p>
* @Title: DepartmentMapper.java
* <p>
* @Package com.oceansoft.mapper
* <p>
* @author zjw
* <p>
* @version V1.0
* <p>
* @date   2015-5-27 ����10:45:15
* <p>
*/
package com.oceansoft.mapper;

import java.util.List;
import java.util.Map;

import com.oceansoft.domain.Department;

/**
 * @Description: �������ݲ�ӿ�
 *
 * @author zjw
 * 
 *      @create time  2015-5-27 ����10:45:15
 */
public interface DepartmentMapper {

	/**
	 * Description: ���Ź����������ѯ
	 *         
	 * @create time ����12:42:21
	 *
	 * @param params
	 * @return       
	 *
	 */
	public List<Department> getDepartmentList(Map<String, Object> params);

	/**
	 * Description: �û���ѯ��ؼ�¼������
	 *         
	 * @create time ����12:50:52
	 *
	 * @param department
	 * @return       
	 *
	 */
	public int getDepartmentListTotal(Department department);

	/**
	 * Description: ��Ӳ���
	 *         
	 * @create time ����12:58:23
	 *
	 * @param department       
	 *
	 */
	public void saveDepartment(Department department);

	/**
	 * Description: ɾ��ָ������
	 *         
	 * @create time ����1:58:45
	 *
	 * @param id
	 * @return       
	 *
	 */
	public int deleteDepartment(int id);

	/**
	 * Description: ���ݱ�ż��ز���
	 *         
	 * @create time ����2:50:48
	 *
	 * @param id
	 * @return       
	 *
	 */
	public Department findById(int id);

	/**
	 * Description: ���²���
	 *         
	 * @create time ����3:08:11
	 *
	 * @param department       
	 *
	 */
	public void updateDepartment(Department department);

	/**
	 * Description: ��ѯ���еĲ���
	 *         
	 * @create time ����9:35:18
	 *
	 * @return       
	 *
	 */
	public List<Department> findAllDepartment();

}
