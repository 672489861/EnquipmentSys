/**
* <p>
* @Title: EquipmentServiceImpl.java
* <p>
* @Package com.oceansoft.service.impl
* <p>
* @author zjw
* <p>
* @version V1.0
* <p>
* @date   2015-5-30 下午2:24:02
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
import com.oceansoft.domain.Equipment;
import com.oceansoft.domain.EquipmentType;
import com.oceansoft.mapper.EquipmentMapper;
import com.oceansoft.service.EquipmentService;
import com.oceansoft.util.PageBean;

/**
 * @Description: 设备业务层实现类
 *
 * @author zjw
 * 
 *      @create time  2015-5-30 下午2:24:02
 */
@Service
public class EquipmentServiceImpl implements EquipmentService{
	
	@Resource
	private EquipmentMapper equipmentMapper;

	@Override
	public int getEquipmentTotalWithTypeId(int id) {
		return equipmentMapper.getEquipementTotalWithTypeId(id);
	}

	@Override
	@ReadOnlyTransaction
	public Map<String, Object> equipmentList(String page, Equipment equipment) {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Constants.pageSize);
		Map<String, Object> params = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		params.put("start", pageBean.getStart());
		params.put("size", Constants.pageSize);
		params.put("equipment", equipment);
		List<EquipmentType> resultList = equipmentMapper.getEquipmentList(params);
		int total = equipmentMapper.getEquipmentTotal(equipment);
		resultMap.put("equipmentList", resultList);
		resultMap.put("total", total);
		return resultMap;
	}

	@Override
	@ReadWriteTransaction
	public int deleteEquipment(int id) {
		return equipmentMapper.deleteEquipment(id);
	}

	@Override
	@ReadOnlyTransaction
	public Equipment getEquipmentById(String id) {
		return equipmentMapper.getEquipmentById(Integer.parseInt(id));
	}

	@Override
	@ReadWriteTransaction
	public void update(Equipment equipment) {
		equipmentMapper.update(equipment);
	}

	@Override
	@ReadWriteTransaction
	public void save(Equipment equipment) {
		equipmentMapper.save(equipment);
	}
	
}
