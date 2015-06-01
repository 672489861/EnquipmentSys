/**
* <p>
* @Title: DepartmentServiceImpl.java
* <p>
* @Package com.oceansoft.service.impl
* <p>
* @author zjw
* <p>
* @version V1.0
* <p>
* @date   2015-5-27 下午10:46:06
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
import com.oceansoft.domain.Department;
import com.oceansoft.mapper.DepartmentMapper;
import com.oceansoft.service.DepartmentService;
import com.oceansoft.util.PageBean;

/**
 * @Description: 部门业务层实现类
 *
 * @author zjw
 * 
 *      @create time  2015-5-27 下午10:46:06
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Resource
	private DepartmentMapper departmentMapper;

	@Override
	@ReadOnlyTransaction
	public Map<String, Object> departmentList(String page, Department department) {
		PageBean bean = new PageBean(Integer.parseInt(page), Constants.pageSize);
		Map<String, Object> params = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		params.put("start", bean.getStart());
		params.put("size", Constants.pageSize);
		params.put("department", department);
		List<Department> resultList = departmentMapper.getDepartmentList(params);
		int total = departmentMapper.getDepartmentListTotal(department);
		resultMap.put("resultList", resultList);
		resultMap.put("total", total);
		return resultMap;
	}

	@Override
	@ReadWriteTransaction
	public void saveDepartment(Department department) {
		departmentMapper.saveDepartment(department);
	}

	@Override
	@ReadWriteTransaction
	public int deleteDepartment(int id) {
		return departmentMapper.deleteDepartment(id);
	}

	@Override
	@ReadOnlyTransaction
	public Department findById(String id) {
		return departmentMapper.findById(Integer.parseInt(id));
	}

	@Override
	@ReadWriteTransaction
	public void updateDepartment(Department department) {
		departmentMapper.updateDepartment(department);
	}

	@Override
	@ReadOnlyTransaction
	public List<Department> findAllDepartment() {
		return departmentMapper.findAllDepartment();
	}

}
