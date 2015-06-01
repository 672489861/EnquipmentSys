/**
* <p>
* @Title: EquipmentTypeService.java
* <p>
* @Package com.oceansoft.service
* <p>
* @author zjw
* <p>
* @version V1.0
* <p>
* @date   2015-5-29 上午10:51:13
* <p>
*/
package com.oceansoft.service;

import java.util.List;
import java.util.Map;

import com.oceansoft.domain.EquipmentType;

/**
 * @Description: 设备类型业务层接口
 *
 * @author zjw
 * 
 *      @create time  2015-5-29 上午10:51:13
 */
public interface EquipmentTypeService {

	/**
	 * Description: 设备类型主界面查询
	 *         
	 * @create time 上午10:59:16
	 *
	 * @param page
	 * @param equipmentType
	 * @return       
	 *
	 */
	public Map<String, Object> equipmentList(String page, EquipmentType equipmentType);

	/**
	 * Description: 删除设备类型
	 *         
	 * @create time 下午2:56:58
	 *
	 * @param id
	 * @return       
	 *
	 */
	public int deleteEquipmentType(int id);

	/**
	 * Description: 根据编号加载设备类型
	 *         
	 * @create time 下午4:52:38
	 *
	 * @param parseInt
	 * @return       
	 *
	 */
	public EquipmentType getEquipmentTypeById(int parseInt);

	/**
	 * Description: 修改设备类型
	 *         
	 * @create time 下午5:31:47
	 *
	 * @param equipmentType       
	 *
	 */
	public void updateEquipmentType(EquipmentType equipmentType);

	/**
	 * Description: 添加设备类型
	 *         
	 * @create time 下午5:31:50
	 *
	 * @param equipmentType       
	 *
	 */
	public void saveEquipmentType(EquipmentType equipmentType);

	/**
	 * Description: 加载所有的设备类型
	 *         
	 * @create time 下午2:08:26
	 *
	 * @return       
	 *
	 */
	public List<EquipmentType> getAllEquipmentType();

}
