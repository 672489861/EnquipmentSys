/**
* <p>
* @Title: EquipmenttypeController.java
* <p>
* @Package com.oceansoft.controller
* <p>
* @author zjw
* <p>
* @version V1.0
* <p>
* @date   2015-5-29 上午10:50:32
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
import com.oceansoft.domain.EquipmentType;
import com.oceansoft.service.EquipmentService;
import com.oceansoft.service.EquipmentTypeService;
import com.oceansoft.util.PageUtil;

/**
 * @Description: 设备类型控制器
 *
 * @author zjw
 * 
 *      @create time  2015-5-29 上午10:50:32
 */
@Controller
@RequestMapping("/equipmentType")
public class EquipmentTypeController {

	@Resource
	private EquipmentTypeService equipmentTypeService;

	@Resource
	private EquipmentService equipmentService;

	/***
	 * 
	 * Description: 设备类型主界面查询
	 *         
	 * @create time 上午10:54:01
	 *
	 * @param equipmentType
	 * @param model
	 * @param request
	 * @return       
	 *
	 */

	@RequestMapping("/list.do")
	public String equipementTypeList(EquipmentType equipmentType, ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String page = request.getParameter("page");
		if (StringUtils.hasText(page)) {
			equipmentType = (EquipmentType) session.getAttribute("s_equipmentType");
		} else {
			page = "1";
			session.setAttribute("s_equipmentType", equipmentType);
		}
		Map<String, Object> resultMap = equipmentTypeService.equipmentList(page, equipmentType);
		String pageCode = PageUtil.getPagation(request.getContextPath() + "/equipmentType/list.do", (Integer) resultMap.get("total"),
				Integer.parseInt(page), Constants.pageSize);
		model.addAttribute("modeName", "设备管理");
		model.addAttribute("equipmentTypeList", resultMap.get("equipmentTypeList"));
		model.addAttribute("pageCode", pageCode);
		model.addAttribute("mainPage", "/WEB-INF/pages/equipmentType/list.jsp");
		return "main";
	}

	/***
	 * 
	 * Description: 删除设备类型
	 *         
	 * @create time 下午2:13:16
	 *
	 * @param id
	 * @param model       
	 *
	 */

	@RequestMapping("/delete.json")
	public void deleteEquipementType(@RequestParam("id")
	int id, ModelMap model) {
		int Etotal = equipmentService.getEquipmentTotalWithTypeId(id);
		if (Etotal != 0) {
			model.addAttribute("success", false);
			model.addAttribute("errorInfo", "该设备类型下有设备,无法删除!");
			return;
		}
		int total = equipmentTypeService.deleteEquipmentType(id);
		if (total == 1) {
			model.addAttribute("success", true);
		} else {
			model.addAttribute("success", false);
		}
		return;
	}

	/***
	 * 
	 * Description: 跳转添加或者修改界面
	 *         
	 * @create time 下午4:48:51
	 *
	 * @param id
	 * @param model
	 * @return       
	 *
	 */

	@RequestMapping("/preSave.do")
	public String preSave(@RequestParam(value = "id", required = false)
	String id, ModelMap model) {
		model.addAttribute("modeName", "设备管理");
		model.addAttribute("mainPage", "/WEB-INF/pages/equipmentType/save.jsp");
		if (StringUtils.hasText(id)) { // 修改
			EquipmentType equipmentType = equipmentTypeService.getEquipmentTypeById(Integer.parseInt(id));
			model.addAttribute("equipmentType", equipmentType);
			model.addAttribute("actionName", "设备修改");
		} else { // 添加
			model.addAttribute("actionName", "设备添加");
		}
		return "main";
	}

	/***
	 * 
	 * Description: 添加或修改设备类型
	 *         
	 * @create time 下午5:29:11
	 *
	 * @param equipmentType
	 * @param model
	 * @return       
	 *
	 */

	@RequestMapping("/save.do")
	public String save(EquipmentType equipmentType, ModelMap model) {
		if (equipmentType.getId() != null) {
			equipmentTypeService.updateEquipmentType(equipmentType);
		} else {
			equipmentTypeService.saveEquipmentType(equipmentType);
		}
		return "redirect:/equipmentType/list.do";
	}

}
