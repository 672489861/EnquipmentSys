/**
* <p>
* @Title: RepairServiceImpl.java
* <p>
* @Package com.oceansoft.service.impl
* <p>
* @author zjw
* <p>
* @version V1.0
* <p>
* @date   2015-6-1 下午10:03:36
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
import com.oceansoft.domain.Repair;
import com.oceansoft.mapper.EquipmentMapper;
import com.oceansoft.mapper.RepairMapper;
import com.oceansoft.service.RepairService;
import com.oceansoft.util.PageBean;

/**
 * @Description: 设备维修业务层实现类
 *
 * @author zjw
 * 
 *      @create time  2015-6-1 下午10:03:36
 */
@Service
public class RepairServiceImpl implements RepairService {

	@Resource
	private RepairMapper repairMapper;

	@Resource
	private EquipmentMapper equipmentMapper;

	@Override
	@ReadWriteTransaction
	public int repairEquipment(String id, String userName) {
		int total = repairMapper.repairEquipment(Integer.parseInt(id), userName);
		total += equipmentMapper.updateStateWithId(Integer.parseInt(id));
		return total;
	}

	@Override
	@ReadOnlyTransaction
	public Map<String, Object> repairList(String page, Repair repair) {
		Map<String, Object> params = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		PageBean bean = new PageBean(Integer.parseInt(page), Constants.pageSize);
		params.put("start", bean.getStart());
		params.put("size", Constants.pageSize);
		params.put("repair", repair);
		List<Repair> repairs = repairMapper.getRepairList(params);
		int total = repairMapper.getRepairListTotal(repair);
		resultMap.put("repairList", repairs);
		resultMap.put("total", total);
		return resultMap;
	}

	@Override
	@ReadWriteTransaction
	public int successRepair(String equipmentId, String id, String state,String userName) throws Exception {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("id", Integer.parseInt(id));
		params.put("userName",userName);
		params.put("state", Integer.parseInt(state));
		int total = repairMapper.updateState(params);
		if(total != 1){
			throw new Exception();
		}
		total += equipmentMapper.updateStateWithSuccessRepair(Integer.parseInt(equipmentId),Integer.parseInt(state));
		return total;
	}

}
