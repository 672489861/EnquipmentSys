/**
* <p>
* @Title: RepairController.java
* <p>
* @Package com.oceansoft.controller
* <p>
* @author zjw
* <p>
* @version V1.0
* <p>
* @date   2015-6-1 下午10:02:25
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
import com.oceansoft.domain.Repair;
import com.oceansoft.domain.User;
import com.oceansoft.service.RepairService;
import com.oceansoft.util.PageUtil;

/**
 * @Description: 设备维修控制器
 *
 * @author zjw
 * 
 *      @create time  2015-6-1 下午10:02:25
 */
@Controller
@RequestMapping("/repair")
public class RepairController {

	@Resource
	private RepairService repairService;

	/***
	 * 
	 * Description: 报修设备
	 *         
	 * @create time 下午10:26:42
	 *
	 * @param id
	 * @param session       
	 *
	 */

	@RequestMapping("/repairEquipment.json")
	public void repairEquipment(@RequestParam("id")
	String id, HttpSession session, ModelMap model) {
		String userName = ((User) session.getAttribute("currentUser")).getUserName();
		int i = repairService.repairEquipment(id, userName);
		if (i == 2) {
			model.addAttribute("success", true);
		} else {
			model.addAttribute("success", false);
		}
	}

	/***
	 * 
	 * Description: 维修设备管理
	 *         
	 * @create time 上午11:28:11
	 *
	 * @param repair
	 * @param model
	 * @param request
	 * @return       
	 *
	 */

	@RequestMapping("/repairList.do")
	public String repairList(Repair repair, ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String page = request.getParameter("page");
		if (StringUtils.hasText(page)) {
			repair = (Repair) session.getAttribute("s_repair");
		} else {
			page = "1";
			session.setAttribute("s_repair", repair);
		}
		repair.setFinishState("1");
		Map<String, Object> resultMap = repairService.repairList(page, repair);
		String pageCode = PageUtil.getPagation(request.getContextPath() + "/repair/repairList.do", (Integer) resultMap.get("total"),
				Integer.parseInt(page), Constants.pageSize);
		model.addAttribute("pageCode", pageCode);
		model.addAttribute("mainPage", "/WEB-INF/pages/repair/list.jsp");
		model.addAttribute("modeName", "维修设备管理");
		model.addAttribute("repairList", resultMap.get("repairList"));
		return "main";
	}
	
	/***
	 * 
	 * Description: 维修设备管理
	 *         
	 * @create time 上午11:28:11
	 *
	 * @param repair
	 * @param model
	 * @param request
	 * @return       
	 *
	 */

	@RequestMapping("/repairHistory.do")
	public String repairHistoryList(Repair repair, ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String page = request.getParameter("page");
		if (StringUtils.hasText(page)) {
			repair = (Repair) session.getAttribute("s_repair");
		} else {
			page = "1";
			session.setAttribute("s_repair", repair);
		}
		repair.setFinishState("2");
		Map<String, Object> resultMap = repairService.repairList(page, repair);
		String pageCode = PageUtil.getPagation(request.getContextPath() + "/repair/repairHistory.do", (Integer) resultMap.get("total"),
				Integer.parseInt(page), Constants.pageSize);
		model.addAttribute("pageCode", pageCode);
		model.addAttribute("mainPage", "/WEB-INF/pages/repair/historyList.jsp");
		model.addAttribute("modeName", "维修历史");
		model.addAttribute("repairList", resultMap.get("repairList"));
		return "main";
	}
	
	/***
	 * 
	 * Description: 修理或报废设备
	 *         
	 * @create time 下午2:24:07
	 *
	 * @param request
	 * @param model       
	 *
	 */

	@RequestMapping("/successRepair.json")
	public void successRepair(HttpServletRequest request, ModelMap model, HttpSession session) {
		String userName = ((User) session.getAttribute("currentUser")).getUserName();
		int total = 0;
		try {
			total = repairService.successRepair(request.getParameter("equipmentId"), request.getParameter("id"),
					request.getParameter("state"), userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (total == 2) {
			model.addAttribute("success", true);
		} else {
			model.addAttribute("success", false);
		}
	}
}
