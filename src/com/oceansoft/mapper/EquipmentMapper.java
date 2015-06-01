/**
* <p>
* @Title: EquipmentMapper.java
* <p>
* @Package com.oceansoft.mapper
* <p>
* @author zjw
* <p>
* @version V1.0
* <p>
* @date   2015-5-30 下午2:25:49
* <p>
*/
package com.oceansoft.mapper;

import java.util.List;
import java.util.Map;

import com.oceansoft.domain.Equipment;
import com.oceansoft.domain.EquipmentType;

/**
 * @Description: 设备类型数据层接口
 *
 * @author zjw
 * 
 *      @create time  2015-5-30 下午2:25:49
 */
public interface EquipmentMapper {

	/**
	 * Description: 获取相应设备类型下的设备数目
	 *         
	 * @create time 下午2:50:54
	 *
	 * @param id
	 * @return       
	 *
	 */
	public int getEquipementTotalWithTypeId(int id);

	/**
	 * Description: 采购管理主界面查询
	 *         
	 * @create time 下午12:02:05
	 *
	 * @param params
	 * @return       
	 *
	 */
	public List<EquipmentType> getEquipmentList(Map<String, Object> params);

	/**
	 * Description: 符合条件的记录数
	 *         
	 * @create time 下午12:02:11
	 *
	 * @param equipment
	 * @return       
	 *
	 */
	public int getEquipmentTotal(Equipment equipment);

	/**
	 * Description: 删除设备
	 *         
	 * @create time 下午1:29:42
	 *
	 * @param id
	 * @return       
	 *
	 */
	public int deleteEquipment(int id);

	/**
	 * Description: 根据编号加载采购设备
	 *         
	 * @create time 下午1:46:07
	 *
	 * @param parseInt
	 * @return       
	 *
	 */
	public Equipment getEquipmentById(int parseInt);

	/**
	 * Description: 修改设备
	 *         
	 * @create time 下午3:01:06
	 *
	 * @param equipment       
	 *
	 */
	public void update(Equipment equipment);

	/**
	 * Description: 添加设备
	 *         
	 * @create time 下午3:01:09
	 *
	 * @param equipment       
	 *
	 */
	public void save(Equipment equipment);
	
}
