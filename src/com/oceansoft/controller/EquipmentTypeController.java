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
* @date   2015-5-29 ����10:50:32
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
 * @Description: �豸���Ϳ�����
 *
 * @author zjw
 * 
 *      @create time  2015-5-29 ����10:50:32
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
		model.addAttribute("modeName", "�豸����");
		model.addAttribute("equipmentTypeList", resultMap.get("equipmentTypeList"));
		model.addAttribute("pageCode", pageCode);
		model.addAttribute("mainPage", "/WEB-INF/pages/equipmentType/list.jsp");
		return "main";
	}

	/***
	 * 
	 * Description: ɾ���豸����
	 *         
	 * @create time ����2:13:16
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
			model.addAttribute("errorInfo", "���豸���������豸,�޷�ɾ��!");
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
	 * Description: ��ת��ӻ����޸Ľ���
	 *         
	 * @create time ����4:48:51
	 *
	 * @param id
	 * @param model
	 * @return       
	 *
	 */

	@RequestMapping("/preSave.do")
	public String preSave(@RequestParam(value = "id", required = false)
	String id, ModelMap model) {
		model.addAttribute("modeName", "�豸����");
		model.addAttribute("mainPage", "/WEB-INF/pages/equipmentType/save.jsp");
		if (StringUtils.hasText(id)) { // �޸�
			EquipmentType equipmentType = equipmentTypeService.getEquipmentTypeById(Integer.parseInt(id));
			model.addAttribute("equipmentType", equipmentType);
			model.addAttribute("actionName", "�豸�޸�");
		} else { // ���
			model.addAttribute("actionName", "�豸���");
		}
		return "main";
	}

	/***
	 * 
	 * Description: ��ӻ��޸��豸����
	 *         
	 * @create time ����5:29:11
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
