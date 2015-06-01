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
* @date   2015-5-27 下午10:45:15
* <p>
*/
package com.oceansoft.mapper;

import java.util.List;
import java.util.Map;

import com.oceansoft.domain.Department;

/**
 * @Description: 部门数据层接口
 *
 * @author zjw
 * 
 *      @create time  2015-5-27 下午10:45:15
 */
public interface DepartmentMapper {

	/**
	 * Description: 部门管理主界面查询
	 *         
	 * @create time 上午12:42:21
	 *
	 * @param params
	 * @return       
	 *
	 */
	public List<Department> getDepartmentList(Map<String, Object> params);

	/**
	 * Description: 用户查询相关记录的总数
	 *         
	 * @create time 上午12:50:52
	 *
	 * @param department
	 * @return       
	 *
	 */
	public int getDepartmentListTotal(Department department);

	/**
	 * Description: 添加部门
	 *         
	 * @create time 下午12:58:23
	 *
	 * @param department       
	 *
	 */
	public void saveDepartment(Department department);

	/**
	 * Description: 删除指定部门
	 *         
	 * @create time 下午1:58:45
	 *
	 * @param id
	 * @return       
	 *
	 */
	public int deleteDepartment(int id);

	/**
	 * Description: 根据编号加载部门
	 *         
	 * @create time 下午2:50:48
	 *
	 * @param id
	 * @return       
	 *
	 */
	public Department findById(int id);

	/**
	 * Description: 更新部门
	 *         
	 * @create time 下午3:08:11
	 *
	 * @param department       
	 *
	 */
	public void updateDepartment(Department department);

	/**
	 * Description: 查询所有的部门
	 *         
	 * @create time 下午9:35:18
	 *
	 * @return       
	 *
	 */
	public List<Department> findAllDepartment();

}
