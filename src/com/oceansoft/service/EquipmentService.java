/**
* <p>
* @Title: EquipmentService.java
* <p>
* @Package com.oceansoft.service
* <p>
* @author zjw
* <p>
* @version V1.0
* <p>
* @date   2015-5-30 下午2:23:36
* <p>
*/
package com.oceansoft.service;

import java.util.Map;

import com.oceansoft.domain.Equipment;

/**
 * @Description: 设备管理业务层接口
 *
 * @author zjw
 * 
 *      @create time  2015-5-30 下午2:23:36
 */
public interface EquipmentService {

	/**
	 * Description: 查询相应设备类型下的设备数目
	 *         
	 * @create time 下午2:49:56
	 *
	 * @param id
	 * @return       
	 *
	 */
	public int getEquipmentTotalWithTypeId(int id);

	/**
	 * Description: 采购管理主界面查询
	 *         
	 * @create time 下午12:01:11
	 *
	 * @param page
	 * @param equipment
	 * @return       
	 *
	 */
	public Map<String, Object> equipmentList(String page, Equipment equipment);

	/**
	 * Description: 删除指定设备
	 *         
	 * @create time 下午1:28:58
	 *
	 * @param id
	 * @return       
	 *
	 */
	public int deleteEquipment(int id);

	/**
	 * Description: 根据id加载采购设备
	 *         
	 * @create time 下午1:42:38
	 *
	 * @param id
	 * @return       
	 *
	 */
	public Equipment getEquipmentById(String id);

	/**
	 * Description: 修改设备
	 *         
	 * @create time 下午3:00:16
	 *
	 * @param equipment       
	 *
	 */
	public void update(Equipment equipment);

	/**
	 * Description: 添加设备
	 *         
	 * @create time 下午3:00:18
	 *
	 * @param equipment       
	 *
	 */
	public void save(Equipment equipment);

}
