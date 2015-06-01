/**
* <p>
* @Title: EquipmentTypeMapper.java
* <p>
* @Package com.oceansoft.mapper
* <p>
* @author zjw
* <p>
* @version V1.0
* <p>
* @date   2015-5-29 上午10:52:20
* <p>
*/
package com.oceansoft.mapper;

import java.util.List;
import java.util.Map;

import com.oceansoft.domain.EquipmentType;

/**
 * @Description: 设备类型数据层接口
 *
 * @author zjw
 * 
 *      @create time  2015-5-29 上午10:52:20
 */
public interface EquipmentTypeMapper {

	/**
	 * Description: 设备类型主界面查询
	 *         
	 * @create time 上午11:53:43
	 *
	 * @param params
	 * @return       
	 *
	 */
	public List<EquipmentType> getEquipmentList(Map<String, Object> params);

	/**
	 * Description: 查询符合条件的记录数
	 *         
	 * @create time 上午11:53:47
	 *
	 * @param equipmentType
	 * @return       
	 *
	 */
	public int getEquipmentListTotal(EquipmentType equipmentType);

	/**
	 * Description: 删除指定设备类型
	 *         
	 * @create time 下午2:58:31
	 *
	 * @param id
	 * @return       
	 *
	 */
	public int deleteEquipmentType(int id);

	/**
	 * Description: 根据编号加载设备类型
	 *         
	 * @create time 下午4:55:30
	 *
	 * @param id
	 * @return       
	 *
	 */
	public EquipmentType getEquipmentTypeById(int id);

	/**
	 * Description: 修改设备类型
	 *         
	 * @create time 下午5:54:00
	 *
	 * @param equipmentType       
	 *
	 */
	public void updateEquipmentType(EquipmentType equipmentType);

	/**
	 * Description: 添加设备类型
	 *         
	 * @create time 下午5:55:28
	 *
	 * @param equipmentType       
	 *
	 */
	public void saveEquipmentType(EquipmentType equipmentType);

	/**
	 * Description: 加载所有的设备类型
	 *         
	 * @create time 下午2:09:45
	 *
	 * @return       
	 *
	 */
	public List<EquipmentType> getAllEquipmentType();

}
