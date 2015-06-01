/**
* <p>
* @Title: EquipmentTypeServiceImpl.java
* <p>
* @Package com.oceansoft.service.impl
* <p>
* @author zjw
* <p>
* @version V1.0
* <p>
* @date   2015-5-29 上午10:51:39
* <p>
*/
package com.oceansoft.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oceansoft.common.Constants;
import com.oceansoft.domain.EquipmentType;
import com.oceansoft.mapper.EquipmentTypeMapper;
import com.oceansoft.service.EquipmentTypeService;
import com.oceansoft.util.PageBean;

/**
 * @Description: 设备类型业务层实现类
 *
 * @author zjw
 * 
 *      @create time  2015-5-29 上午10:51:39
 */
@Service
public class EquipmentTypeServiceImpl implements EquipmentTypeService {

	@Resource
	private EquipmentTypeMapper equipmentTypeMapper;

	@Override
	public Map<String, Object> equipmentList(String page, EquipmentType equipmentType) {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Constants.pageSize);
		Map<String, Object> params = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		params.put("start", pageBean.getStart());
		params.put("size", Constants.pageSize);
		params.put("equipmentType", equipmentType);
		List<EquipmentType> resultList = equipmentTypeMapper.getEquipmentList(params);
		int total = equipmentTypeMapper.getEquipmentListTotal(equipmentType);
		resultMap.put("equipmentTypeList", resultList);
		resultMap.put("total", total);
		return resultMap;
	}

	@Override
	public int deleteEquipmentType(int id) {
		return equipmentTypeMapper.deleteEquipmentType(id);
	}

	@Override
	public EquipmentType getEquipmentTypeById(int id) {
		return equipmentTypeMapper.getEquipmentTypeById(id);
	}

	@Override
	public void updateEquipmentType(EquipmentType equipmentType) {
		equipmentTypeMapper.updateEquipmentType(equipmentType);
	}

	@Override
	public void saveEquipmentType(EquipmentType equipmentType) {
		equipmentTypeMapper.saveEquipmentType(equipmentType);
	}

	@Override
	public List<EquipmentType> getAllEquipmentType() {
		return equipmentTypeMapper.getAllEquipmentType();
	}

}
