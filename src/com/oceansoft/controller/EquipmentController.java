/**
* <p>
* @Title: EquipmentController.java
* <p>
* @Package com.oceansoft.controller
* <p>
* @author zjw
* <p>
* @version V1.0
* <p>
* @date   2015-5-30 ����2:24:30
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
import com.oceansoft.domain.Equipment;
import com.oceansoft.domain.EquipmentType;
import com.oceansoft.service.EquipmentService;
import com.oceansoft.service.EquipmentTypeService;
import com.oceansoft.util.PageUtil;

/**
 * @Description: �豸���������
 *
 * @author zjw
 * 
 *      @create time  2015-5-30 ����2:24:30
 */
@Controller
@RequestMapping("/equipment")
public class EquipmentController {

	@Resource
	private EquipmentService equipmentService;

	@Resource
	private EquipmentTypeService equipmentTypeService;

	/***
	 * 
	 * Description: �豸�����������ѯ
	 *         
	 * @create time ����10:54:01
	 *
	 * @param equipmentType
	 * @param model
	 * @param request
	 * @return       
	 *
	 */

	@RequestMapping("/list.do")
	public String equipementList(Equipment equipment, ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String page = request.getParameter("page");
		if (StringUtils.hasText(page)) {
			equipment = (Equipment) session.getAttribute("s_equipment");
		} else {
			page = "1";
			session.setAttribute("s_equipment", equipment);
		}
		Map<String, Object> resultMap = equipmentService.equipmentList(page, equipment);
		String pageCode = PageUtil.getPagation(request.getContextPath() + "/equipment/list.do", (Integer) resultMap.get("total"),
				Integer.parseInt(page), Constants.pageSize);
		model.addAttribute("modeName", "�ɹ�����");
		model.addAttribute("equipmentList", resultMap.get("equipmentList"));
		model.addAttribute("pageCode", pageCode);
		model.addAttribute("mainPage", "/WEB-INF/pages/equipment/list.jsp");
		return "main";
	}

	/***
	 * 
	 * Description: �豸�����������ѯ
	 *         
	 * @create time ����10:54:01
	 *
	 * @param equipmentType
	 * @param model
	 * @param request
	 * @return       
	 *
	 */

	@RequestMapping("/useList.do")
	public String useEquipmentList(Equipment equipment, ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String page = request.getParameter("page");
		if (StringUtils.hasText(page)) {
			equipment = (Equipment) session.getAttribute("s_equipment");
		} else {
			page = "1";
			session.setAttribute("s_equipment", equipment);
		}
		Map<String, Object> resultMap = equipmentService.equipmentList(page, equipment);
		String pageCode = PageUtil.getPagation(request.getContextPath() + "/equipment/useList.do", (Integer) resultMap.get("total"),
				Integer.parseInt(page), Constants.pageSize);
		model.addAttribute("modeName", "ʹ���豸����");
		model.addAttribute("equipmentList", resultMap.get("equipmentList"));
		model.addAttribute("pageCode", pageCode);
		model.addAttribute("mainPage", "/WEB-INF/pages/equipment/useList.jsp");
		return "main";
	}

	
	/***
	 * 
	 * Description: ɾ���豸
	 *         
	 * @create time ����1:27:44
	 *
	 * @param id
	 * @param model       
	 *
	 */

	@RequestMapping("/delete.json")
	public void deleteEquipment(@RequestParam("id")
	int id, ModelMap model) {
		int i = equipmentService.deleteEquipment(id);
		if (i == 1) {
			model.addAttribute("success", true);
		} else {
			model.addAttribute("success", false);
		}
	}

	/***
	 * 
	 * Description: ��ת��ӻ����޸Ľ���
	 *         
	 * @create time ����1:32:38
	 *
	 * @param id
	 * @param model
	 * @return       
	 *
	 */

	@RequestMapping("/preSave.do")
	public String preSave(@RequestParam(value = "id", required = false)
	String id, ModelMap model) {
		if (StringUtils.hasText(id)) { // �޸�
			Equipment equipment = equipmentService.getEquipmentById(id);
			model.addAttribute("equipment", equipment);
			model.addAttribute("actionName", "�ɹ��޸�");
		} else { // ��� 
			model.addAttribute("actionName", "�ɹ����");
		}
		List<EquipmentType> equipmentTypes = equipmentTypeService.getAllEquipmentType();
		model.addAttribute("equipmentTypes", equipmentTypes);
		model.addAttribute("modeName", "�ɹ�����");
		model.addAttribute("mainPage", "/WEB-INF/pages/equipment/save.jsp");
		return "main";
	}

	/***
	 * 
	 * Description: ��ӻ��޸Ĳ���
	 *         
	 * @create time ����2:38:35
	 *
	 * @param equipment
	 * @return       
	 *
	 */

	@RequestMapping("/save.do")
	public String save(Equipment equipment) {
		if (equipment.getId() != null) {
			equipmentService.update(equipment);
		} else {
			equipmentService.save(equipment);
		}
		return "redirect:/equipment/list.do";
	}

}
