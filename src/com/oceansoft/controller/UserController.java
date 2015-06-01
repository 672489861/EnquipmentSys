/**
* <p>
* @Title: UserController.java
* <p>
* @Package com.oceansoft.controller
* <p>
* @author zjw
* <p>
* @version V1.0
* <p>
* @date   2015-5-27 ����4:03:13
* <p>
*/
package com.oceansoft.controller;

import java.util.List;
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
import com.oceansoft.domain.User;
import com.oceansoft.service.DepartmentService;
import com.oceansoft.service.UserService;
import com.oceansoft.util.PageUtil;

/**
 * @Description: �û���¼������
 *
 * @author zjw
 * 
 *      @create time  2015-5-27 ����4:03:13
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;

	@Resource
	private DepartmentService departmentService;

	/***
	 * 
	 * Description: ��ת��¼����
	 *         
	 * @create time ����4:37:46
	 *
	 * @return       
	 *
	 */

	@RequestMapping("/toLogin.html")
	public String toLogin() {
		return "login";
	}

	/***
	 * 
	 * Description: �û���¼
	 *         
	 * @create time ����4:18:02
	 *
	 * @param user
	 * @param request
	 * @return       
	 *
	 */

	@RequestMapping("/login.do")
	public String login(User user, HttpServletRequest request) {
		User resultUser = userService.login(user);
		if (resultUser == null) {
			request.setAttribute("user", user);
			request.setAttribute("errorMsg", "�û������������");
			return "login";
		} else {
			request.getSession().setAttribute("currentUser", resultUser);
			// ===========�ض���ָ������==============
			return "redirect:/user/toMain.html";
		}
	}

	/***
	 * 
	 * Description: ��ת������
	 *         
	 * @create time ����4:18:11
	 *
	 * @return       
	 *
	 */

	@RequestMapping("/toMain.html")
	public String toMain() {
		return "main";
	}

	/***
	 * 
	 * Description: �û��������ѯ
	 *         
	 * @create time ����3:46:59
	 *
	 * @param request
	 * @param user
	 * @param model
	 * @return       
	 *
	 */

	@RequestMapping("/list.do")
	public String userList(HttpServletRequest request, User user, ModelMap model) {
		HttpSession session = request.getSession();
		String page = request.getParameter("page");
		if (StringUtils.hasText(page)) {
			user = (User) session.getAttribute("s_user");
		} else {
			page = "1";
			session.setAttribute("s_user", user);
		}
		Map<String, Object> resultMap = userService.userList(page, user);
		String pageCode = PageUtil.getPagation(request.getContextPath() + "/user/list.do", (Integer) resultMap.get("total"),
				Integer.parseInt(page), Constants.pageSize);
		model.addAttribute("modeName", "�û�����");
		model.addAttribute("pageCode", pageCode);
		model.addAttribute("userList", resultMap.get("userList"));
		model.addAttribute("mainPage", "/WEB-INF/pages/user/list.jsp");
		return "main";
	}

	/***
	 * 
	 * Description: ɾ��ָ���û�
	 *         
	 * @create time ����8:29:25
	 *
	 * @param id       
	 *
	 */

	@RequestMapping("/delete.json")
	public void deleteUser(@RequestParam("id")
	int id, ModelMap model) {
		int total = userService.deleteUser(id);
		if (total == 1) {
			model.addAttribute("success", true);
		} else {
			model.addAttribute("success", false);
		}
	}

	/***
	 * 
	 * Description: ��ת��ӻ���½���
	 *         
	 * @create time ����8:35:22
	 *
	 * @param id
	 * @param model       
	 *
	 */

	@RequestMapping("/preSave.do")
	public String preSave(@RequestParam(value = "id", required = false)
	String id, ModelMap model) {
		model.addAttribute("mainPage", "/WEB-INF/pages/user/save.jsp");
		model.addAttribute("modeName", "�û�����");
		if (StringUtils.hasText(id)) {
			User user = userService.findById(Integer.parseInt(id));
			model.addAttribute("user", user);
			model.addAttribute("actionName", "�޸��û�");
		} else {
			model.addAttribute("actionName", "����û�");
		}
		List<Department> departments = departmentService.findAllDepartment();
		model.addAttribute("departmentList", departments);
		return "main";
	}
	
	/***
	 * 
	 * Description: ��ӻ��޸��û�
	 *         
	 * @create time ����9:52:49
	 *
	 * @param user
	 * @return       
	 *
	 */
	
	@RequestMapping("/save.do")
	public String save(User user) {
		if (user.getId() == null) {
			userService.saveUser(user);
		} else {
			userService.updateUser(user);
		}
		return "redirect:/user/list.do";
	}
	
	/***
	 * 
	 * Description: ��ȫ�˳�
	 *         
	 * @create time ����7:56:04
	 *
	 * @param session
	 * @return       
	 *
	 */
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session){
		session.removeAttribute("currentUser");
		session.invalidate();
		return "login";
	}
	
}
