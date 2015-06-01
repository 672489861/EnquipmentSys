/**
* <p>
* @Title: DepartmentController.java
* <p>
* @Package com.oceansoft.controller
* <p>
* @author zjw
* <p>
* @version V1.0
* <p>
* @date   2015-5-27 下午10:44:13
* <p>
*/
package com.oceansoft.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oceansoft.common.Constants;
import com.oceansoft.domain.Department;
import com.oceansoft.service.DepartmentService;
import com.oceansoft.service.UserService;
import com.oceansoft.util.PageUtil;

/**
 * @Description: 部门控制器
 *
 * @author zjw
 * 
 *      @create time  2015-5-27 下午10:44:13
 */
@RequestMapping("/department")
@Controller
public class DepartmentController {

	@Resource
	private DepartmentService departmentService;

	@Resource
	private UserService userService;

	/***
	 * 
	 * Description: 部门管理主界面查询
	 *         
	 * @create time 下午11:58:26
	 *
	 * @param request
	 * @param model       
	 *
	 */

	@RequestMapping("/list.do")
	public String departmentList(HttpServletRequest request, ModelMap model, Department department) {
		HttpSession session = request.getSession();
		String page = request.getParameter("page");
		if (StringUtils.hasText(page)) {
			department = (Department) session.getAttribute("s_department");
		} else {
			page = "1";
			session.setAttribute("s_department", department);
		}
		Map<String, Object> resultMap = departmentService.departmentList(page, department);
		String pageCode = PageUtil.getPagation(request.getContextPath() + "/department/list.do", (Integer) resultMap.get("total"),
				Integer.parseInt(page), Constants.pageSize);
		model.addAttribute("departmentList", resultMap.get("resultList"));
		model.addAttribute("modeName", "部门管理");
		model.addAttribute("pageCode", pageCode);
		model.addAttribute("mainPage", "/WEB-INF/pages/department/list.jsp");
		return "main";
	}

	/***
	 * 
	 * Description: 跳转部门添加或修改界面
	 *         
	 * @create time 下午12:41:46
	 *
	 * @param model
	 * @return       
	 *
	 */

	@RequestMapping("/preSave.do")
	public String toSave(@RequestParam(value = "id", required = false)
	String id, ModelMap model) {
		model.addAttribute("mainPage", "/WEB-INF/pages/department/save.jsp");
		model.addAttribute("modeName", "部门管理");
		if (StringUtils.hasText(id)) { // 修改
			Department department = departmentService.findById(id);
			model.addAttribute("department", department);
			model.addAttribute("actionName", "部门修改");
		} else {
			model.addAttribute("actionName", "部门添加"); // 添加
		}
		return "main";
	}

	/***
	 * 
	 * Description: 添加或修改部门
	 *         
	 * @create time 下午12:53:42
	 *
	 * @param department
	 * @param model
	 * @return       
	 *
	 */

	@RequestMapping("/save.do")
	public String saveDepartment(Department department, ModelMap model) {
		if (department.getId() == null) {
			departmentService.saveDepartment(department);
		} else {
			departmentService.updateDepartment(department);
		}
		return "redirect:/department/list.do";
	}

	/***
	 * 
	 * Description: 删除部门
	 *         
	 * @create time 下午1:56:10
	 *
	 * @param id
	 * @param model       
	 *
	 */
	@RequestMapping("/delete.json")
	public void deleteDepartment(@RequestParam("id")
	int id, ModelMap model, HttpServletRequest request) {
		int userTotal = userService.getTotalByDept(id);
		if (userTotal != 0) {
			model.addAttribute("success", false);
			model.addAttribute("errorInfo", "该部门下有人员,无法删除!");
			return;
		}
		int total = departmentService.deleteDepartment(id);
		if (total == 1) {
			model.addAttribute("success", true);
		} else {
			model.addAttribute("success", false);
		}
	}

}
