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
* @date   2015-5-27 下午10:45:47
* <p>
*/
package com.oceansoft.service;

import java.util.List;
import java.util.Map;

import com.oceansoft.domain.Department;

/**
 * @Description: 部门业务层接口
 *
 * @author zjw
 * 
 *      @create time  2015-5-27 下午10:45:47
 */
public interface DepartmentService {

	/**
	 * Description: 部门管理主界面查询
	 *         
	 * @create time 上午12:37:56
	 *
	 * @param page
	 * @param department
	 * @return       
	 *
	 */
	public Map<String, Object> departmentList(String page, Department department);

	/**
	 * Description: 添加部门
	 *         
	 * @create time 下午12:57:22
	 *
	 * @param department       
	 *
	 */
	public void saveDepartment(Department department);

	/**
	 * Description: 删除部门
	 *         
	 * @create time 下午1:58:15
	 *
	 * @param id
	 * @return       
	 *
	 */
	public int deleteDepartment(int id);

	/**
	 * Description: 根据编号加载部门
	 *         
	 * @create time 下午2:49:35
	 *
	 * @param id
	 * @return       
	 *
	 */
	public Department findById(String id);

	/**
	 * Description: 更新部门
	 *         
	 * @create time 下午2:55:53
	 *
	 * @param department       
	 *
	 */
	public void updateDepartment(Department department);

	/**
	 * Description: 查询所有的部门
	 *         
	 * @create time 下午9:34:51
	 *
	 * @return       
	 *
	 */
	public List<Department> findAllDepartment();

}
