/**
* <p>
* @Title: RepairService.java
* <p>
* @Package com.oceansoft.service
* <p>
* @author zjw
* <p>
* @version V1.0
* <p>
* @date   2015-6-1 下午10:03:18
* <p>
*/
package com.oceansoft.service;

import java.util.Map;

import com.oceansoft.domain.Repair;

/**
 * @Description: 设备维修业务层接口
 *
 * @author zjw
 * 
 *      @create time  2015-6-1 下午10:03:18
 */
public interface RepairService {

	/**
	 * Description: 报修设备
	 *         
	 * @create time 下午10:39:13
	 *
	 * @param id
	 * @param userName
	 * @return       
	 *
	 */
	public int repairEquipment(String id, String userName);

	/**
	 * Description: 维修设备管理主界面查询
	 *         
	 * @create time 上午11:54:43
	 *
	 * @param page
	 * @param repair
	 * @return       
	 *
	 */
	public Map<String, Object> repairList(String page, Repair repair);

	/**
	 * Description: 修理或报废设备
	 *         
	 * @create time 下午2:28:00
	 *
	 * @param equipmentId
	 * @param id
	 * @param state
	 * @param userName 
	 * @return       
	 *
	 */
	public int successRepair(String equipmentId, String id, String state, String userName)throws Exception;

}
